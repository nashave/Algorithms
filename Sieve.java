import kotlin.coroutines.experimental.buildSequence

 fun sieve(isPrime: Int, ints: Sequence<Int>): Boolean = with(ints.first()){
     return when {
         isPrime  < 2 -> false
         isPrime == 2 -> true
         isPrime == this -> true
         isPrime.rem(2) == 0 -> false
         this > isPrime -> false
         else -> sieve(isPrime, ints.filter { n -> n.rem(this) != 0 })
     }
 }

 fun main(args: Array<String>) {
     val lazySeq = buildSequence { for (i in 3..Int.MAX_VALUE step 2) yield(i) }
     println("Duration = ${measureTimeMillis { println("isPrime(4057) = ${sieve(4057, lazySeq)}") }}ms")
 }
