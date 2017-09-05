package com.google.firebase.udacity.friendlychat

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MessageAdapter(context: Context, resource: Int, objects: List<FriendlyMessage>) : ArrayAdapter<FriendlyMessage>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = (context as Activity).layoutInflater.inflate(R.layout.item_message, parent, false)
        }

        val photoImageView = convertView!!.findViewById<ImageView>(R.id.photoImageView)
        val messageTextView = convertView.findViewById<TextView>(R.id.messageTextView)
        val authorTextView = convertView.findViewById<TextView>(R.id.nameTextView)

        val message = getItem(position)

        val isPhoto = message!!.photoUrl != null
        if (isPhoto) {
            messageTextView.visibility = View.GONE
            photoImageView.visibility = View.VISIBLE

            GlideApp.with(photoImageView.context)
                    .load(message.photoUrl)
                    .into(photoImageView)
        } else {
            messageTextView.visibility = View.VISIBLE
            photoImageView.visibility = View.GONE
            messageTextView.text = message.text
        }
        authorTextView.text = message.name

        return convertView
    }
}
