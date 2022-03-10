package valdez.ignacio.chatbot.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {

    fun basicResponse(_message:String):String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{

            //Flips a coin
            message.contains("flip") && message.contains("coin")->{
                val r = (0..1).random()
                val result = if(r==0) "heads" else "tails"
                "I flipped a coin and it landed on $result"
            }
            message.contains("solve")->{
                val equation:String? = message.substringAfterLast("solve")
                return try{
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"
                }catch(e: Exception){
                    "Sorry, I can't solve that"
                }
            }
            message.contains("hello")->{
                when(random){
                    0->"Hello there!"
                    1->"sup"
                    2->"Buongiorno!"
                    else->"error"
                }
            }
            message.contains("how are you")->{
                when(random){
                    1->"I'm doin fine, thanks!"
                    2->"I'm hungry..."
                    else->"error"
                }
            }
            message.contains("time") && message.contains("?")->{
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))
                date.toString()
            }
            else->{
                when(random){
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "Error"
                }
            }

        }
    }

}