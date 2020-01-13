package `in`.testKT.app

import android.app.AppComponentFactory
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class LamdaTest: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        couroutineTest()

      /*  val MyLambda:(Int)->Unit = {i:Int-> println("value::$i")}
        addNumber(1,2,MyLambda)

        val noArgument :()->Unit = {println("No Arguemnt")}
        noArgument()*/
    }

    fun addNumber(a:Int,b:Int,MyLambda:(Int)->Unit){
        val add = a+b
        MyLambda(add)
    }

    fun couroutineTest(){
        println("Kotlin Start")

        // Start a coroutine
        GlobalScope.launch {
            delay(1000)
            println("Hello")
        }

        //Thread.sleep(2000) // wait for 2 seconds
        println("Kotlin Stop")
    }

}