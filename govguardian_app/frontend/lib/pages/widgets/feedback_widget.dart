import 'package:flutter/material.dart';

class UserFeedbackPage extends StatefulWidget {
  @override
  _UserFeedbackScreenState createState() =>
      _UserFeedbackScreenState();
}

class _UserFeedbackScreenState
    extends State<UserFeedbackPage> {
  String? firstName;
  String? lastName;
  String? email;
  String? message;
  int? rating; // Nullable to allow selection from 1 to 5 stars

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  void _submitForm() {
    if (_formKey.currentState!.validate()) {
      _formKey.currentState!.save();

      // Show a dialog to rate the officer
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return StatefulBuilder(
            // Use StatefulBuilder to rebuild the dialog content when rating changes
            builder: (BuildContext context, StateSetter setState) {
              return AlertDialog(
                title: Text('Rate the Government Officer'),
                content: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Text('How would you rate the officer?'),
                    SizedBox(height: 20),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        for (int i = 1; i <= 5; i++)
                          IconButton(
                            icon: Icon(
                              i <= (rating ?? 0) ? Icons.star : Icons.star_border,
                              size: 40.0,
                              color: Colors.amber,
                            ),
                            onPressed: () {
                              setState(() {
                                rating = i; // Update the selected rating
                              });
                            },
                          ),
                      ],
                    ),
                    SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: () {
                        Navigator.of(context).pop(); // Close the dialog
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                            content: Text('Feedback submitted successfully!'),
                            duration: Duration(seconds: 2),
                          ),
                        );
                      },
                      child: Text('Submit Feedback'),
                    ),
                  ],
                ),
              );
            },
          );
        },
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Feedback'),
      ),
      body: Container(
        color: Colors.blueGrey[50],
        padding: EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              _buildField('First Name', (value) {
                firstName = value;
              }),
              SizedBox(height: 20),
              _buildField('Last Name', (value) {
                lastName = value;
              }),
              SizedBox(height: 20),
              _buildField('Email', (value) {
                email = value;
              }),
              SizedBox(height: 20),
              _buildMessageField(),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: _submitForm,
                child: Text('Submit'),
                style: ElevatedButton.styleFrom(
                  primary: Colors.yellow,
                  minimumSize: Size(double.infinity, 50.0),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildField(String label, void Function(String?) onSave) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(10.0),
        boxShadow: [
          BoxShadow(
            color: Colors.grey.withOpacity(0.5),
            spreadRadius: 3,
            blurRadius: 5,
            offset: Offset(0, 3),
          ),
        ],
      ),
      child: TextFormField(
        decoration: InputDecoration(
          labelText: label,
          contentPadding: EdgeInsets.all(16.0),
          border: InputBorder.none,
        ),
        validator: (value) {
          if (value == null || value.isEmpty) {
            return 'Please enter your $label';
          }
          return null;
        },
        onSaved: onSave,
      ),
    );
  }

  Widget _buildMessageField() {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(10.0),
        boxShadow: [
          BoxShadow(
            color: Colors.grey.withOpacity(0.5),
            spreadRadius: 3,
            blurRadius: 5,
            offset: Offset(0, 3),
          ),
        ],
      ),
      child: TextFormField(
        decoration: InputDecoration(
          labelText: 'Message',
          contentPadding: EdgeInsets.all(16.0),
          border: InputBorder.none,
        ),
        maxLines: 4,
        validator: (value) {
          if (value == null || value.isEmpty) {
            return 'Please enter your message';
          }
          return null;
        },
        onSaved: (value) {
          message = value;
        },
      ),
    );
  }
}