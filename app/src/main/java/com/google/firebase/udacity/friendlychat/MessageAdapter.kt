package com.google.firebase.udacity.friendlychat

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class MessageAdapter(private val mActivity: AppCompatActivity, private val mMessages: ArrayList<FriendlyMessage>) :
        RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun getItemCount(): Int {
        return mMessages.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = mMessages[position]

        val isPhoto = message.photoUrl != null
        if (isPhoto) {
            holder.messageTextView.visibility = View.GONE
            holder.photoImageView.visibility = View.VISIBLE

            GlideApp.with(holder.photoImageView.context)
                    .load(message.photoUrl)
                    .into(holder.photoImageView)
        } else {
            holder.messageTextView.visibility = View.VISIBLE
            holder.photoImageView.visibility = View.GONE
            holder.messageTextView.text = message.text
        }
        holder.nameTextView.text = message.name

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MessageViewHolder {
        return MessageViewHolder(mActivity.layoutInflater.inflate(R.layout.item_message, parent, false))
    }

    fun add(friendlyMessage: FriendlyMessage) {
        mMessages.add(friendlyMessage)
        notifyItemInserted(mMessages.size - 1)
    }

    fun clear() {
        mMessages.clear()
        notifyDataSetChanged()
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
        var messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    }

}
