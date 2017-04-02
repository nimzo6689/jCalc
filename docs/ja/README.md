# jCalc - Powered by JavaFX8

[![Build Status](https://travis-ci.org/nimzo6689/jCalc.svg?branch=master)](https://travis-ci.org/nimzo6689/jCalc)
[![Coverage Status](https://coveralls.io/repos/github/nimzo6689/jCalc/badge.svg)](https://coveralls.io/github/nimzo6689/jCalc)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/nimzo6689/jCalc/blob/master/LICENSE)
<p align="right"><a href="..">English</a></p>

JavaFX + Maven で開発したシンプルな電卓アプリです。

## 概要

当プロジェクトはCI（継続的インテグレーション）ツールを用いてJavaFXアプリの開発を行うためのデモとなります。実際の業務でも同じような実装、設定内容でも済むように心掛けました。JavaFX開発を始めてする人にとって、より生産性、機敏性、保守性、柔軟性を向上させるヒントになればと考えています。

## 目的

- 実際の業務でも適用できる水準で実装されたJavaFXアプリのデモを行うこと。
- Mavenを利用したCIツールの構築すること。
- JavaFX周辺技術の例示すること。

## 実行方法

ソースコードはGitHubページからZip形式でダウンロードするか、ブラウザ上からでも閲覧することができます。
当アプリはMavenを使用しているため、お好きなIDEで簡単にビルドが行えます。

また、CUI上でMavenコマンドから直接実行することも可能です。その場合は以下のコマンドになります。
mvn clear jfx:run

## 設計

当アプリは下記に示す通り、Stateパターンを用いて実装しています。
![alt tag](https://raw.githubusercontent.com/nimzo6689/jCalc/master/documents/ICalcSate.png)

## CIツールによる出力内容

現在のソースコードのメトリクスやJavaDoc、ビルド内容は下記のリンクにて閲覧可能です。

[jCalc Project Site](https://nimzo6689.github.io/jCalc/site/)
