package com.example.adoptionpet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(private val messages: List<Message>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageIcon: ImageView = view.findViewById(R.id.messageIcon)
        val messageTextView: TextView = view.findViewById(R.id.messageTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return MessageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        with(holder) {
            messageTextView.text = message.text
            messageIcon.setImageResource(message.imageResId)

            val iconParams = messageIcon.layoutParams as RelativeLayout.LayoutParams
            val textParams = messageTextView.layoutParams as RelativeLayout.LayoutParams

            if (message.isUserMessage) {
                iconParams.addRule(RelativeLayout.ALIGN_PARENT_END)
                iconParams.removeRule(RelativeLayout.ALIGN_PARENT_START)
                textParams.addRule(RelativeLayout.START_OF, R.id.messageIcon)
                textParams.removeRule(RelativeLayout.END_OF)
            } else {
                iconParams.addRule(RelativeLayout.ALIGN_PARENT_START)
                iconParams.removeRule(RelativeLayout.ALIGN_PARENT_END)
                textParams.addRule(RelativeLayout.END_OF, R.id.messageIcon)
                textParams.removeRule(RelativeLayout.START_OF)
            }

            messageIcon.layoutParams = iconParams
            messageTextView.layoutParams = textParams
        }
    }

    override fun getItemCount() = messages.size
}
