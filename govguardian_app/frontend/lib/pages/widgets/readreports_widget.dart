import 'package:flutter/material.dart';

class ReadReportsPage extends StatelessWidget {
  final List<Map<String, String>> reports = [
    {'title': 'Corruption at XYZ Department', 'date': 'April 24, 2024', 'member': 'John Doe'},
    {'title': 'Bribery Incident at ABC Office', 'date': 'April 23, 2024', 'member': 'Jane Smith'},
    {'title': 'Misuse of Funds in Project ABC', 'date': 'April 22, 2024', 'member': 'Alice Johnson'},
    {'title': 'Kickback Allegations in XYZ Project', 'date': 'April 21, 2024', 'member': 'Bob Williams'},
    // Add more sample reports as needed
  ];

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: reports.length,
      itemBuilder: (context, index) {
        return Card(
          margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 15.0),
          child: ListTile(
            contentPadding: EdgeInsets.symmetric(vertical: 20.0, horizontal: 20.0),
            title: Text(
              reports[index]['title'] ?? '', // Adding ?? '' to handle null case
              style: TextStyle(fontSize: 18.0, fontWeight: FontWeight.bold),
            ),

            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Submitted on: ${reports[index]['date']}',
                  style: TextStyle(fontSize: 14.0),
                ),
                SizedBox(height: 5.0),
                Text(
                  'Submitted by: ${reports[index]['member']}',
                  style: TextStyle(fontSize: 14.0),
                ),
              ],
            ),
            onTap: () {
              // Add navigation to detailed report page
              // Example: Navigator.push(context, MaterialPageRoute(builder: (context) => ReportDetailPage(report: reports[index])));
            },
          ),
        );
      },
    );
  }
}
