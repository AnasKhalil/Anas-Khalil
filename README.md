**********************************************************************************************
**********************************************************************************************
**********************************************************************************************
TEST PLAN
**********************************************************************************************
**********************************************************************************************
**********************************************************************************************
These ideas are sorted into two main categories:

1. Non-functional categories which include:
   a. Navigation tests
   b. UI tests
2. Functional categories which include:
   a. Basic functions tests
   b. Business related functions tests

The prioritization of these ideas according to their possible business impact
is indicated by the number right next to each of them where 1 is the least prior 
and 5 is the most prior.

**********************************************************************************

Navigation tests:
1. Validate that "الرئيسية" tab opens successfully (5)
2. Validate that "مباريات" tab opens successfully (5)
3. Validate that "بطولات" tab opens successfully (5)
4. Validate that "فرقك" tab opens successfully (5)
5. Validate that "اخبار" tab opens successfully (5)

UI tests:
1. Validate UI requirements
Since I don't have a functional specification document, I can summarize the main UI requirements in the following points:
a. Font sizes are consistent and matching (3)
b. Icons, buttons and field margins are all consistent (2)
c. Font type is unified (1)
2. Validate that news sections contain relevant data (4)
3. Validate UI is consistent through different operating systems (3)
4. Validate UI is consistent through different devices (3)
5. Validate UI is stable when rotating mobile screen over different operating systems and devices (1)

Basic functions tests:
1. Validate that all buttons are clickable and do what they are intended to do (5)
2. Validate that different combinations between all basic functions and navigations behave correctly (5)
3. Validate that all search textboxes behave correctly, and search results are related to search keywords used (4)

Business functions tests:
1. Verify that matches stats are updated correctly for past matches (5)
2. Verify that matches stats are updated instantaneously for live matches (refreshing) over different networks (5)
3. Verify that matches scheduled in the future are displayed in the calendar in their correct dates (5)
4. Validate that teams stats are updated correctly post matches (5)
5. Validate that players stats are updated correctly post matches (not found) (5)
6. Verify that current leagues stats are correct (5)


**********************************************************************************************
**********************************************************************************************
BUG REPORT
**********************************************************************************************
**********************************************************************************************
IMPORTANT NOTE:- All needed attachments are located in "Bug report attachments" folder,
each attachment name maps to numbers next to the bug's title
**********************************************************************************************
1. After opening a league, it is empty

Bug type:- Functional

Pre-requisites:- None

Steps to reproduce:-
1. Open the app
2. Click on "فرقك" tab
3. Click on "أضف فريقك"
4. Select any league (champions league)
5. Select any team (PSG & Bayern)
6. Click the back button to go back to leagues menu
7. Use the search bar using any key word (مصر)
8. Click on any of the search results

Expected result:- The selected league list is opened successfully 

Actual result:- The league opened is empty

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Network type:- (Wi-Fi)

Severity:- Moderate
Priority:- High

************************************************************************

2. While opening a specific league, a different league is opened 

Bug type:- Functional

Pre-requisites:- None

Steps to reproduce:-
1. Open the app
2. Click on the "فرقك" tab
3. Search using any key word (مصر)
4. Select any result (كأس مصر)
Note: if there is no result displayed click on the "x" icon to delete the search data
5. Select any result (الأهلي)
6. Click on the back button
7. Search using a different key word (كأس)
8. Select any result (كأس الأمم الأفريقية)

Expected result:- The league selected is opened successfully (كأس الأمم الأفريقية)

Actual result:- The first league selected is opened (كأس مصر)

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Network type:- (Wi-Fi)

Severity:- Moderate
Priority:- High

************************************************************************

3. App crashes when clicking the play icon

Bug type:- Functional

Pre-requisites:- None

Steps to reproduce:- 
1. Open the app
2. Click on "فرقك" tab
3. Click on "مباريات" tab
4. Click on the play icon on the upper right-hand side of the screen

Expected result:- Live matches screen is opened successfully

Actual result:- App crashes
Note:- The app will not crash if an Ad is displayed after clicking the play icon

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Network type:- (Wi-Fi)

Severity:- Show Stopper
Priority:- Critical

************************************************************************

4. No cancel/back button in calendar from "مباريات" screen

Bug type:- Usability

Pre-requisites:- None

Steps to reproduce:-
1. Open the app
2. Click on the "مباريات" tab
3. Click on the calendar icon on the upper right-hand side of the screen

Expected result:- There is a cancel/back button to exit go back to 
the "مباريات" tab

Actual result:- There is no cancel/back button and user can not exit the
calendar except by selecting a date or killing the app and re-opening it

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Network type:- (Wi-Fi)

Severity:- Low
Priority:- Low

************************************************************************

5. Days with matches should be marked in the calendar

Bug type:- Usability 

Pre-requisites:- None

Steps to reproduce:-
1. Open the app
2. Click on "مباريات" tab
3. Click on the calendar icon on the upper right hand side of the screen

Expected result:- Days with matches should be marked in a different colour
than days where no matches are played

Actual result:- All days are similar and user has to open them day by day
to check for matches on that day

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Network type:- (Wi-Fi)

Severity:- Low
Priority:- Low

************************************************************************

6. No internet connection error while network is connected and stable

Bug type:- Functional

pre-requisites:- Make sure network connection is stable

Steps to reproduce:-
1. Open the app
2. Click on any match in the handball league
3. Click on any of the participating teams

Expected result:- The team profile is opened successfully

Actual result:- An error is displayed that there is no network connection

Affected devices:-
1. OPPO Reno 6 5g
2. iPhone 11 Pro Max

Networks type:- (Wi-Fi) & mobile data

Severity:- Major
Priority:- High

