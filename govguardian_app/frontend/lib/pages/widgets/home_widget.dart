import 'package:flutter/material.dart';

class UserHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Dummy user data (replace with actual user data)
    String username = 'JohnDoe';
    String email = 'john.doe@example.com';
    // Dummy profile picture (replace with actual profile picture)
    String profilePictureUrl = 'https://via.placeholder.com/150';

    return Scaffold(
      appBar: AppBar(
        title: Text('Gov Guardian'),
      ),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Profile Section
            Container(
              padding: EdgeInsets.all(20.0),
              color: Colors.blue,
              child: Row(
                children: [
                  CircleAvatar(
                    radius: 40.0,
                    backgroundImage: NetworkImage(profilePictureUrl),
                  ),
                  SizedBox(width: 20.0),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'Welcome, $username!',
                        style: TextStyle(
                          fontSize: 18.0,
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                        ),
                      ),
                      SizedBox(height: 5.0),
                      Text(
                        email,
                        style: TextStyle(
                          fontSize: 16.0,
                          color: Colors.white,
                        ),
                      ),
                    ],
                  ),
                  Spacer(),
                  IconButton(
                    icon: Icon(Icons.edit),
                    color: Colors.white,
                    onPressed: () {
                      // Navigate to edit profile screen
                    },
                  ),
                  IconButton(
                    icon: Icon(Icons.logout),
                    color: Colors.white,
                    onPressed: () {
                      // Log out user
                    },
                  ),
                ],
              ),
            ),
            // Report Option
            ListTile(
              title: Text('Report Corruption'),
              leading: Icon(Icons.report),
              onTap: () {
                // Navigate to report screen
              },
            ),
            Divider(),
            // Chatbot Section
            ListTile(
              title: Text('Chat with Gov Bot'),
              leading: Icon(Icons.chat),
              onTap: () {
                // Open chatbot interface
              },
            ),
            Divider(),
            // About Us Section
            ListTile(
              title: Text('About Us'),
              leading: Icon(Icons.info),
              onTap: () {
                // Navigate to about us screen
              },
            ),
            Divider(),
            // Chat Option
            ListTile(
              title: Text('Chat with Community Member'),
              leading: Icon(Icons.chat_bubble),
              onTap: () {
                // Open chat interface
              },
            ),
          ],
        ),
      ),
    );
  }
}
