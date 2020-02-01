package main

import (
	"net/http"

	"golang.org/x/crypto/acme"
	"golang.org/x/crypto/acme/autocert"
)

func main() {
	client := &acme.Client{
		DirectoryURL: "http://localhost:4001/directory",
	}
	manager := &autocert.Manager{
		Cache:      autocert.DirCache("secret-dir"),
		Prompt:     autocert.AcceptTOS,
		HostPolicy: autocert.HostWhitelist("akhtikddayo.com", "www.akhtikddayo.com"),
		Client:     client,
	}

	s := &http.Server{
		Addr:      ":https",
		TLSConfig: manager.TLSConfig(),
		Handler:   manager.HTTPHandler(nil),
	}

	s.ListenAndServeTLS("", "")
}
