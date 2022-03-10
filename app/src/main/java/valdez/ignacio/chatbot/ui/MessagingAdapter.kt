package valdez.ignacio.chatbot.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item.view.*
import valdez.ignacio.chatbot.R
import valdez.ignacio.chatbot.data.Message
import valdez.ignacio.chatbot.utils.Constans.RECEIVE_ID
import valdez.ignacio.chatbot.utils.Constans.SEND_ID

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {
    var messageList = mutableListOf<Message>()
    inner class MessageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener{

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messageList[position]
        when(currentMessage.id){
            SEND_ID->{
                holder.itemView.tv_message.apply{
                    text=currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility=View.GONE
            }
            RECEIVE_ID->{
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility=View.GONE
            }

        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    fun insertMessage(message:Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
        notifyDataSetChanged()
    }


}