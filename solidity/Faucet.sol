pragma solidity ^0.6.0;

// Our first contract is a faucet!
contract Faucet {
    // Accept any incoming amount
    receive () external payable {}

    // Give out ether to anyone who asks
    function withdraw(uint withdraw_amount) public {

        // Limit withdrawal amount
        require(withdraw_amount <= 100000000000000000);

        // Send the amount to the address that requested it
        msg.sender.transfer(withdraw_amount);
    }
}

// $ docker run --rm -v `pwd`:`pwd` -w `pwd` ethereum/solc:stable --optimize --bin Faucet.sol
//
// ======= Faucet.sol:Faucet =======
// Binary:
// 608060405234801561001057600080fd5b5060cc8061001f6000396000f3fe608060405260043610601f5760003560e01c80632e1a7d4d14602a576025565b36602557005b600080fd5b348015603557600080fd5b50605060048036036020811015604a57600080fd5b50356052565b005b67016345785d8a0000811115606657600080fd5b604051339082156108fc029083906000818181858888f193505050501580156092573d6000803e3d6000fd5b505056fea26469706673582212200430bda8a8efdc40801965966908cbce649822f923f18519b9b9e3bf0748f03364736f6c63430006040033

// $ docker run --rm -v `pwd`:`pwd` -w `pwd` ethereum/solc:stable --abi Faucet.sol
//
// ======= Faucet.sol:Faucet =======
// Contract JSON ABI
// [{"inputs":[{"internalType":"uint256","name":"withdraw_amount","type":"uint256"}],"name":"withdraw","outputs":[],"stateMutability":"nonpayable","type":"function"},{"stateMutability":"payable","type":"receive"}]
