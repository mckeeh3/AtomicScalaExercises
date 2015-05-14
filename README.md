# AtomicScalaExercises
Atomic Scala book V2 completed exercises using work sheets

Excellent book! Was exactly what I needed to get into some of the basics of
the Scala language. Would be a good book to use to prepare for the Coursera
classes:

- Functional Programming Principles in Scala
- Principles of Reactive Programming

Book flow is short micro-chapters called atoms. Each atom ends with an exercise.
The exercises typically includes a few (~4-5) programming problems. Basically
the flow of the book is to read a few pages that introduce some aspect of Scala
followed by exercises that allow for playing with the new material.

Most of the exercises included tests provided in the description. This provided
a form of test driven problem solving.

Completed all 73 of the exercises in the 2nd edition in Intellij using Scala
worksheets. For the most part this worked out well. In some cases other source
files were needed.

## Some notes on small problems with some exercises

In the String Interpolation exercise question 1 there is a reference to
"The Garden Gnome example in Auxiliary Constructors". There is no reference
to the Garden Nome class in that exercise in V2 book.

The provided tests in question 3 of exercise String Interpolation is incorrect.
Test provided is (bob.show() is "height: 15.0 weight: 100.0 true true"). The
test should be (bob.show() is "height: 15.0 weight: 100.0 happy: false painted: true).

Question 1 in the Reaching into Java exercise has an invalid variable in the provided
tests. The variable provided is "myDate" but the provided variable is "mayDay".
