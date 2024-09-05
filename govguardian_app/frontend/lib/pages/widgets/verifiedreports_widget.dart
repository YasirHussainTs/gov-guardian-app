import 'package:flutter/material.dart';

class CheckReportPage extends StatelessWidget {
  final List<Map<String, dynamic>> officers = [
    {'name': 'John Doe', 'position': 'Chief Officer'},
    {'name': 'Jane Smith', 'position': 'Inspector'},
    {'name': 'David Johnson', 'position': 'Supervisor'},
  ];

  final List<Map<String, dynamic>> reports = [
    {'officer': 'John Doe', 'description': 'Misuse of funds'},
    {'officer': 'Jane Smith', 'description': 'Bribery'},
    {'officer': 'David Johnson', 'description': 'Corruption'},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Check Report'),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            SizedBox(height: 20.0),
            Text(
              'Government Officers',
              style: TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
            ),
            DataTable(
              columns: [
                DataColumn(label: Text('Name')),
                DataColumn(label: Text('Position')),
              ],
              rows: officers
                  .map(
                    (officer) => DataRow(cells: [
                  DataCell(Text(officer['name'])),
                  DataCell(Text(officer['position'])),
                ]),
              )
                  .toList(),
            ),
            SizedBox(height: 20.0),
            Text(
              'Reports',
              style: TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
            ),
            DataTable(
              columns: [
                DataColumn(label: Text('Officer')),
                DataColumn(label: Text('Description')),
              ],
              rows: reports
                  .map(
                    (report) => DataRow(cells: [
                  DataCell(Text(report['officer'])),
                  DataCell(Text(report['description'])),
                ]),
              )
                  .toList(),
            ),
            SizedBox(height: 20.0),
            ElevatedButton(
              onPressed: () {
                // Placeholder for fetching reports from server
              },
              child: Text('Refresh'),
            ),
          ],
        ),
      ),
    );
  }
}
