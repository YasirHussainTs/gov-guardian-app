import 'package:flutter/material.dart';

class UserChatBox extends StatefulWidget {
  @override
  UserChatBoxState createState() => UserChatBoxState();
}

class UserChatBoxState extends State<UserChatBox> {
  TextEditingController _messageController = TextEditingController();
  List<Map<String, dynamic>> _messages = [];

  void _sendMessage(String message) {
    setState(() {
      _messages.add({"message": message, "sentByUser": true});
    });
    _messageController.clear();
  }

  void _deleteMessage(int index, {bool deleteForEveryone = false}) {
    setState(() {
      if (deleteForEveryone) {
        _messages.removeAt(index);
      } else {
        _messages[index]["message"] = 'This message has been deleted';
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: Text('ComunityMemberChat'),
        actions: [
          Row(
            children: [
              IconButton(
                icon: Icon(Icons.camera_alt),
                onPressed: () {
                  // Handle camera button press
                },
              ),
              IconButton(
                icon: Icon(Icons.videocam),
                onPressed: () {
                  // Handle video button press
                },
              ),
              IconButton(
                icon: Icon(Icons.settings),
                onPressed: () {
                  // Handle settings button press
                },
              ),
              IconButton(
                icon: Icon(Icons.cancel),
                onPressed: () {
                  // Handle cancel button press
                },
              ),
            ],
          ),
        ],
      ),
      body: Column(
        children: <Widget>[
          Expanded(
            child: ListView.builder(
              reverse: false,
              itemCount: _messages.length,
              itemBuilder: (context, index) {
                return Padding(
                  padding: EdgeInsets.symmetric(vertical: 4.0, horizontal: 8.0),
                  child: Row(
                    mainAxisAlignment: _messages[index]["sentByUser"]
                        ? MainAxisAlignment.end
                        : MainAxisAlignment.start,
                    children: [
                      Container(
                        decoration: BoxDecoration(
                          color: _messages[index]["sentByUser"]
                              ? Colors.blue
                              : Colors.grey[200],
                          borderRadius: BorderRadius.circular(8.0),
                        ),
                        padding: EdgeInsets.all(12.0),
                        child: Text(
                          _messages[index]["message"],
                          style: TextStyle(
                            fontSize: 16.0,
                            color: _messages[index]["sentByUser"]
                                ? Colors.white
                                : Colors.black,
                          ),
                        ),
                      ),
                      IconButton(
                        icon: Icon(Icons.delete),
                        onPressed: () {
                          showDialog(
                            context: context,
                            builder: (BuildContext context) {
                              return AlertDialog(
                                title: Text('Delete Message'),
                                content:
                                Text('Do you want to delete this message?'),
                                actions: <Widget>[
                                  TextButton(
                                    onPressed: () {
                                      Navigator.of(context).pop();
                                    },
                                    child: Text('Cancel'),
                                  ),
                                  TextButton(
                                    onPressed: () {
                                      _deleteMessage(index,
                                          deleteForEveryone: true);
                                      Navigator.of(context).pop();
                                    },
                                    child: Text('Delete for Everyone'),
                                  ),
                                  TextButton(
                                    onPressed: () {
                                      _deleteMessage(index);
                                      Navigator.of(context).pop();
                                    },
                                    child: Text('Delete for Me'),
                                  ),
                                ],
                              );
                            },
                          );
                        },
                      ),
                    ],
                  ),
                );
              },
            ),
          ),
          Padding(
            padding: EdgeInsets.all(8.0),
            child: Row(
              children: <Widget>[
                Expanded(
                  child: TextField(
                    controller: _messageController,
                    decoration: InputDecoration(
                      hintText: 'Type your message...',
                      filled: true,
                      fillColor: Colors.white,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(30.0),
                      ),
                      contentPadding: EdgeInsets.all(12.0),
                    ),
                    onSubmitted: (String value) {
                      if (value.isNotEmpty) {
                        _sendMessage(value);
                      }
                    },
                  ),
                ),
                SizedBox(width: 8.0),
                IconButton(
                  icon: Icon(Icons.send),
                  onPressed: () {
                    if (_messageController.text.isNotEmpty) {
                      _sendMessage(_messageController.text);
                    }
                  },
                ),
              ],
            ),
          ),
        ],
      ),
      bottomNavigationBar: Container(
        color: Colors.grey[300],
        padding: EdgeInsets.symmetric(vertical: 8.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            IconButton(
              icon: Icon(Icons.photo),
              onPressed: () {
                // Handle gallery button press
              },
            ),
            IconButton(
              icon: Icon(Icons.notifications),
              onPressed: () {
                // Handle notifications button press
              },
            ),
            IconButton(
              icon: Icon(Icons.emoji_emotions),
              onPressed: () {
                // Handle emojis button press
              },
            ),
            IconButton(
              icon: Icon(Icons.attach_file),
              onPressed: () {
                // Handle attachments button press
              },
            ),
            IconButton(
              icon: Icon(Icons.camera_alt),
              onPressed: () {
                // Handle camera button press
              },
            ),
            IconButton(
              icon: Icon(Icons.insert_drive_file),
              onPressed: () {
                // Handle files button press
              },
            ),
          ],
        ),
      ),
    );
  }
}