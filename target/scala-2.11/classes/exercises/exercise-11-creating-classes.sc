// 1. Create classes for Hippo, Lion, Tiger, Monkey, and Giraffe, then
// create an instance of each one of those classes. Display the objects.
// Do you see five different ugly-looking (but unique) strings? Count
// and inspect them.

class Hippo {}
class Lion {}
class Tiger {}
class Monkey {}
class Giraffe {}

println(new Hippo)
println(new Lion)
println(new Tiger)
println(new Monkey)
println(new Giraffe)

// 2. Create a second instance of Lion and two more Giraffes. Print
//    those objects. How do they differ from the original objects that you
//    created?

println(new Lion)
println(new Giraffe)
println(new Giraffe)

// 3. Create a class Zebra that prints “I have stripes” when you create it.
//    Test it.

class Zebra {
  println("I have stripes")
}

println(new Zebra)
