# Let's encrypt

> Let’s Encrypt は、公共の利益のために運営されている、フリーで自動化されたオープンな認証局 (certificate authority; CA) です。

https://letsencrypt.org/ja/about/ より

> 90日間有効なDV（Domain Validation）SSL証明書を2つの認証方式（ドメイン認証、DNS認証）で提供しています。

https://ssl.sakura.ad.jp/column/letsencrypt/ より


>あなたのウェブサイトで HTTPS を有効にするためには、認証局 (Certificate Authority; CA) から証明書 (ファイルの一種) を取得する必要があります。Let’s Encrypt は認証局の1つです。あなたのウェブサイトのドメインのための証明書を Let’s Encrypt から取得するには、あなたが自分のドメインをコントロールする権利があることを示す必要があります。Let’s Encrypt では、ACME プロトコルというルールを使用するソフトウェアを使って、この証明を行います。このソフトウェアは、通常はあなたのウェブホスト上で実行します。

https://letsencrypt.org/ja/getting-started/ より

>Let’s EncryptのSSL証明書発行システムの大きな特徴は、ACME（Automated Certificate Management Environment）プロトコルと呼ばれるSSL証明書を自動発行する仕組みを利用している点です。

https://ssl.sakura.ad.jp/column/letsencrypt/ より


## 証明書の自動取得には2つのステップがある

- 1. CAに対してウェブサーバがそのドメインをコントロールしていることを証明するプロセス
- 2. そのドメインに対して、証明書管理エージェントが証明書のリクエスト・更新・無効化を行うプロセス


## 補足：Well-Known URI
httpやhttpsでは、Well-Known URIというものがあり特定用途に使用するURIが予約できるようになっています。
[RFC 5785 - Defining Well-Known Uniform Resource Identifiers (URIs)](https://tools.ietf.org/html/rfc5785)

例えば、https://example.com/.well-known/○○○○○ のように /.well-known/ 以下に特定用途のURIが予約されます。
例えば、https://example.com/.well-known/○○○○○ のように /.well-known/ 以下に特定用途のURIが予約されます。

現在登録されているWell-Known URIの一覧は、IANAのページから確認できます ([Well-Known URIs](https://www.iana.org/assignments/well-known-uris/well-known-uris.xhtml))

例えば以下のような物があります

- /.well-known/acme-challenge/ : 証明書自動発行のためのプロトコルであるACMEで、チャレンジに使用される
- /.well-known/http-opportunistic : HTTPで日和見暗号を使用する際の情報が記載される
- /.well-known/dns-query : DNS over HTTPのリクエスト先URIとして使用される(策定中の仕様)

## チャレンジの種類
https://letsencrypt.org/ja/docs/challenge-types/ より

>Let’s Encrypt から証明書を取得するときには、ACME 標準で定義されている「チャレンジ」を使用して、証明書が証明しようとしているドメイン名があなたの制御下にあることを検証します。

要するに、`example.com の証明書が欲しいと要求してきた人が 本当に example.com の所有者かの確認`。

- HTTP-01 チャレンジ
- DNS-01 チャレンジ
- TLS-ALPN-01 チャレンジ

Let's Encrypt が求めるのは以下のような操作です。

- HTTP で http://example.com/.well-known/acme-challenge/ に対して Let's Encrypt が指定したテキストを返す設定をする
- DNS で _acme-challenge.example.com に対して Let's Encrypt が指定した値を返す TXT レコードを設定する
- example.com のサーバで TLS を有効にする

ドメイン所有者はこれを行い、 Let's Encrypt が設定の正しさを外から確認することで、ドメインの所有者を確認し、証明書を発行します。 Let's Encrypt への依頼は API 経由でできるため、そこで受け取ったトークンを用いて、これらのプロセスさえ自動化できれば、完全自動で証明書が発行できるわけです。

## Let's Encrypt の発行する証明書
CA が発行する証明書にはいくつかの種類があります。

- DV(Domain Validation): ドメインの所有を確認して発行
- OV(Organization Validation): 組織の実在の確認をして発行
- EV(Extended Validation): より厳密な実在確認をして発行

Let's Encrypt が発行できるのは、この DV 証明書だけです。

ワイルドカード証明書は発行できない。

## 用語
- CSR = Certificate Signing Request
  - CSRとは『公開鍵情報』と『ウェブサイトの所有者情報(ディスティングイッシュネーム)』で構成された、SSLサーバ証明書を発行している認証局へ送信する署名リクエスト(Certificate Signing Request) のことです。
