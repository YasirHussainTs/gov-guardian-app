import 'package:flutter/material.dart';

class VerifyReportPage extends StatelessWidget {
  final List<String> reports = [
    'Report 1: Corruption at XYZ Department',
    'Report 2: Bribery Incident at ABC Office',
    'Report 3: Misuse of Funds in Project ABC',
    'Report 4: Kickback Allegations in XYZ Project',
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
              reports[index],
              style: TextStyle(fontSize: 18.0, fontWeight: FontWeight.bold),
            ),
            subtitle: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  'Fraudulent',
                  style: TextStyle(fontSize: 14.0, color: Colors.red),
                ),
                Text(
                  'Non-violent',
                  style: TextStyle(fontSize: 14.0, color: Colors.green),
                ),
              ],
            ),
            onTap: () {
              // Add logic for assigning officers as fraudulent or non-violent
            },
          ),
        );
      },
    );
  }
}
