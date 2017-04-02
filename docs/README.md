# jCalc - Powered by JavaFX8

[![Build Status](https://travis-ci.org/nimzo6689/jCalc.svg?branch=master)](https://travis-ci.org/nimzo6689/jCalc)
[![Coverage Status](https://coveralls.io/repos/github/nimzo6689/jCalc/badge.svg)](https://coveralls.io/github/nimzo6689/jCalc)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/nimzo6689/jCalc/blob/master/LICENSE)

A simple calculator which is created with JavaFX and Maven.

## Overview

This project demonstrates how you can develop applications with the Java FX platform using CI tools. The code is intended to mirror a simple calculator application that developers in the real work would work on. It attempts to demonstrate first-hand how you can use Java FX to effectively meet practical enterprise concerns such as productivity, agility, testability, flexibility and maintainability.

## Goals

- Demonstrate well established architectural patterns/blueprints for enterprise development with Java FX using pretty close to a real world application.
- Demonstre a build settings of CI concepts.
- Showcase some core Java EX technologies.

## Getting Started

If you simply wish to explore the code, download it as a Zip or browse the repository.
The source is a Maven project, so you should be able to easily build it or set it up in your favorite IDE.

You can also run the application directly from the Maven command line. All you need to is navigate to the project source root and type: mvn clear jfx:run

## Background

This app is implemented with State pattern like bellow.
![alt tag](https://raw.githubusercontent.com/nimzo6689/jCalc/master/documents/ICalcSate.png)


<table class="tbl">
      <tbody>
        <tr>
          <td class="th" colspan="2" rowspan="2">
            State Transition <br>Table</td>
          <td class="th" colspan="4">
            State</td>
        </tr>
        <tr>
          <td class="th">
            A: RegisterA</td>
          <td class="th">
            C: Operation</td>
          <td class="th">
            B: RegisterB</td>
          <td class="th">
            R: Result</td>
        </tr>
        <tr>
          <td class="th" rowspan="5">
            Event</td>
          <td class="th">
            0,~,9</td>
          <td>
            Append input number and show it on display.<br>
            &rarr; No change.
          </td>
          <td>
            Clear display.<br>
            Append input number and show it on display.<br>
            &rarr; B
          </td>
          <td>
            Append input number and show it on display.<br>
            &rarr; No change.
          </td>
          <td>
            Clear display.<br>
            Append input number and show it on display.<br>
            &rarr; A
          </td>
        </tr>
        <tr>
          <td class="th">
            Arithmetic<br>
            operations<br>
            &divide; &times; － ＋ . %
          </td>
          <td>
            Store value on the display to registerA.<br>
            Save operator type.<br>
            &rarr; C
          </td>
          <td>
            Save operator type.<br>
            &rarr; No change.
          </td>
          <td>
            Store number on display to registerB.<br>
            Show [RegisterA Operation RegisterB] on display.<br>
            Store number on display to registerA<br>
            Save operator type.<br>
            &rarr; C
          </td>
          <td>
            Show [RegisterA Operation RegisterB] on display.<br>
            Store number on display to registerA<br>
            Save operator type.<br>
            &rarr; C
          </td>
        </tr>
        <tr>
          <td class="th">
            ＝
          </td>
          <td>
            Show value on input.<br>
            &rarr; R
          </td>
          <td>
            In the case of &divide;, &times; Show [RegisterA Operation RegisterB] on display.<br>
            In the case of + or -, show registerA on display.<br>
            &rarr; R
          </td>
          <td>
            Show [RegisterA Operation RegisterB] on display.<br>
            &rarr; R
          </td>
          <td>
            Do nothing.<br>
            &rarr; No change.
          </td>
        </tr>
        <tr>
          <td class="th">
            Clear/All Clear
          </td>
          <td>
            Clear registerA and display.<br>
            &rarr; No change.
          </td>
          <td>
            Clear registerA and display.<br>
            &rarr; A
          </td>
          <td>
            Clear registerB and display.<br>
            &rarr; No change.
          </td>
          <td>
            Clear registerA, registerB and Clear display.<br>
            &rarr; A
          </td>
        </tr>
      </tbody>
    </table>

## Reports of CI tools.

If you confirm maven site reports of current repository, you can get it by bellow link.

[Maven Project Site](https://nimzo6689.github.io/jCalc/site/)
