import 'package:flutter/material.dart';

class UserReportPage extends StatefulWidget {
  @override
  _ReportPageState createState() => _ReportPageState();
}

class _ReportPageState extends State<UserReportPage> {
  bool _imageCaptured = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Report'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            _imageCaptured
                ? Container(
              height: 200,
              width: 200,
              color: Colors.grey[300],
              child: Center(
                child: Icon(
                  Icons.camera_alt,
                  size: 100,
                  color: Colors.grey[600],
                ),
              ),
            )
                : ElevatedButton.icon(
              onPressed: () {
                // Placeholder for camera capture functionality
                // Implement camera capture functionality here
                setState(() {
                  _imageCaptured = true;
                });
              },
              icon: Icon(Icons.camera_alt),
              label: Text('Capture Image'),
            ),
            SizedBox(height: 20.0),
            ElevatedButton(
              onPressed: () {
                // Placeholder for upload functionality
                // Implement upload functionality here
              },
              child: Text('Upload Report'),
            ),
            SizedBox(height: 20.0),
            ElevatedButton(
              onPressed: () {
                // Placeholder for additional feature
              },
              child: Text('Additional Feature'),
            ),
          ],
        ),
      ),
    );
  }
}
