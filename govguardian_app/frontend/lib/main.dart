import 'package:flutter/material.dart';
import 'package:frontend/pages/widgets/about_widget.dart';
import 'package:frontend/pages/widgets/checkreports_widgets.dart';
import 'package:frontend/pages/widgets/readreports_widget.dart';
import 'package:frontend/pages/widgets/verifiedreports_widget.dart';
import 'package:frontend/pages/widgets/feedback_widget.dart';
import 'package:frontend/pages/widgets/home_widget.dart';
import 'package:frontend/pages/widgets/login_widget.dart';
import 'package:frontend/pages/widgets/report_widget.dart';
import 'package:frontend/pages/widgets/signup_widget.dart';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Anti-Government App',
      theme: ThemeData.light().copyWith(
        primaryColor: Colors.white,
        scaffoldBackgroundColor: Colors.white,
        hintColor: Color(0xFFEB1555),
        textTheme: TextTheme(
          bodyText1: TextStyle(
            color: Colors.black,
          ),
        ),
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.white,
          elevation: 0,
          iconTheme: IconThemeData(color: Colors.black),
          toolbarTextStyle: TextTheme(
            headline6: TextStyle(
              color: Colors.black,
              fontSize: 20.0,
              fontWeight: FontWeight.bold,
            ),
          ).bodyText2, titleTextStyle: TextTheme(
          headline6: TextStyle(
            color: Colors.black,
            fontSize: 20.0,
            fontWeight: FontWeight.bold,
          ),
        ).headline6,
        ),
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            primary: Color(0xFFEB1555),
            textStyle: TextStyle(
              fontSize: 18.0,
              fontWeight: FontWeight.bold,
            ),
            padding: EdgeInsets.symmetric(vertical: 15.0, horizontal: 30.0),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(30.0),
            ),
          ),
        ),
      ),
      initialRoute: '/checkreport',
      routes: {
        '/login': (context) => UserLoginPage(),
        '/signup': (context) => UserSignupPage(),
        '/home': (context) => UserHomePage(),
        '/about': (context) => AboutUsPage(),
        '/report': (context) => UserReportPage(),
        '/feedback': (context) => UserFeedbackPage(),
        '/checkreport': (context) => CheckReportPage(),
        '/readreport': (context) => ReadReportsPage(),
        '/verifyreport': (context) => VerifyReportPage(),
      },
    );
  }
}
