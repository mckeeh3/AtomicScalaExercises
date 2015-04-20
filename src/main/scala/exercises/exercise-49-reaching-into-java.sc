
import com.atomicscala.AtomicTest._

// 1. Import the class SimpleDateFormat, used for specifying what the
//    input date string looks like, from java.text.SimpleDateFormat. Use
//    Java’s SimpleDateFormat to create a pattern, named datePattern,
//    that you will parse as 2-digit Month/2-digit Day/2-digit Year (Hint:
//    MM/dd/yy). Satisfy the following test:
//    val mayDay = datePattern.parse("05/01/12")
//    mayDay.getDate is 1
//    mayDate.getMonth is 4

import java.text.SimpleDateFormat

val datePattern = new SimpleDateFormat("MM/dd/yy")

val mayDay = datePattern.parse("05/01/12")
mayDay.getDate is 1
//mayDate.getMonth is 4
mayDay.getMonth is 4

// 2. In your solution for Exercise 1, why do you specify “MM” in the
//    SimpleDateFormat pattern instead of “mm?” What would the
//    parser expect if you specified “mm?” Try it.

// mm ia minute while MM is month
val datePattern2 = new SimpleDateFormat("mm/dd/yy")

val mayDay2 = datePattern2.parse("05/01/12")
mayDay2.getDate is 1
//mayDate.getMonth is 4
mayDay2.getMonth is 0

// 3. In your solution for Exercise 1, why is May represented as a 4
//    instead of a 5? Is this what you would expect? Is this consistent
//    with the day?

val datePattern3 = new SimpleDateFormat("MM/dd/yy")

val mayDate3 = datePattern2.parse("05/10/12")
mayDate3.getDate is 10

// 4. The Apache Commons Math library (imported in this atom),
//    contains a class called Frequency in
//    org.apache.commons.math.stat.Frequency. Use its addValue
//    method to add some strings to Frequency. Satisfy the following
//    test:
//    val f = new Frequency
//    // add values for cat, dog, cat, bird,
//    // cat, cat, kitten, mouse here
//    f.getCount("cat") is 4

// added following as library dependency in build.sbt
import org.apache.commons.math.stat.Frequency

val f = new Frequency
// add values for cat, dog, cat, bird,
// cat, cat, kitten, mouse here
f.addValue("cat")
f.addValue("dog")
f.addValue("cat")
f.addValue("bird")
f.addValue("cat")
f.addValue("cat")
f.addValue("kitten")
f.addValue("mouse")
f.getCount("cat") is 4

// 5. Using the Apache Commons Math library that you imported above,
//    calculate the mean and standard deviation and percentile of the
//    following data set: 10, 20, 30, 80, 90, and 100. Satisfy the following
//    tests:
//    val s = new SummaryStatistics
//    // add values here
//    s.getMean is 55
//    s.getStandardDeviation is
//    39.370039370059054

import org.apache.commons.math.stat.descriptive.SummaryStatistics

val s = new SummaryStatistics
// add values here
s.addValue(10)
s.addValue(20)
s.addValue(30)
s.addValue(80)
s.addValue(90)
s.addValue(100)

s.getMean is 55
s.getStandardDeviation is 39.370039370059054
