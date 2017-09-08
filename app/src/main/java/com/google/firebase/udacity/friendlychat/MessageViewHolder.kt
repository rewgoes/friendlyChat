package com.google.firebase.udacity.friendlychat

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
    var messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
}