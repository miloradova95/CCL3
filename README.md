# CCL3 DreamDex

# Members
Aleksandar Miloradovic & Tiffany Müller

# Description
The app allows fans and fiction enthusiasts to discover their favorite characters and save them to a personalized favorites list. 

----------------------------------------------------------------------------------------------------------------
# Use Case
DreamDex serves as an interactive platform for anime and manga enthusiasts who wish to curate a personal collection of their favourite characters. The app will utilize the AniList, as it provides detailed character data. 

The app provides an engaging, interactive experience that allows users to explore a vast collection of over 17,000 characters. A standout feature is the absence of direct search functionality, meaning users must explore the app and discover new characters along the way, which can become quite addictive. As they browse, users can delve deeper into each character's details and curate a personalized collection by adding their favorites. The "Character Randomizer" feature adds an element of fun and spontaneity, encouraging users to venture beyond their usual picks. It's also perfect for those who are indecisive and enjoy being surprised with a random character suggestion.

Designed to appeal to both casual viewers and dedicated fans, DreamDex provides an intuitive interface that simplifies character discovery and organization. Whether users aim to build a nostalgic archive, or explore new series, DreamDex delivers an immersive and enjoyable experience. Androids Room Database will provide a lightweight database that stores users’ personal character lists locally.

# Target Users
Anime and Manga Viewers:
Individuals who are just beginning to explore anime or manga, and seek a convenient way to learn about popular characters and series.

Dedicated Fans and Collectors:
Enthusiasts deeply invested in pop culture who want to maintain a curated collection of their favourite characters while discovering hidden gems.

Community and Social Sharers:
Fans who enjoy sharing their character preferences with friends and engaging in discussions about their collections.

----------------------------------------------------------------------------------------------------------------

![Mock up](./Mock%20up/Initial%20Mock%20up.png)

# Heuristic Evaluation

The heuristic evaluation is based on the initial mockup above

### 1. Visibility of System Status:

The bottom menu navigation includes icons that inform users about their current location within the app. When a user navigates to a page, the corresponding icon transitions from an outlined icon to a filled icon, providing clear visual feedback about the selected page. This design ensures users always know where they are in the app.

Issue: No confirmation when favoriting/unfavoriting characters.
Severity: 2 (minor usability problem)
Reason: Users may feel uncertain if their input was registered, leading to confusion or repeated actions. The immediate feedback by the heart icon getting filled when a character is favorited might be too small to notice.

Improvements: Confirm Favoriting Action
Displaying a small and short confirmation message like "Added to Favorites" or “Removed from Favorites” when the user clicks the heart icon to favorite or unfavorite character. This feedback reinforces the action and assures users that their input was successful. 

### 2. Match Between System and the Real World:

We selected intuitive icons to align with users' real-world expectations. For example:
- The house icon represents the home screen, a universally understood metaphor.
- When a user clicks on a character's image, they are taken to a detailed view. Adjacent to the image, a heart icon allows users to favorite the character. The outlined heart becomes filled when tapped, providing immediate feedback that the character has been saved. 
- To view their favorites, users can tap the heart icon located in the bottom navigation bar. Since this icon mirrors the one used for favoriting characters, users can easily make the connection. The use of a heart icon aligns with real-world associations, where hearts are intuitively connected to concepts of liking or saving cherished items.
- The x icon in the top-left corner of the details page provides a simple, universally recognized way to close the page and return to the previous screen.
- The globe icon represents the explore feature, which displays a list of characters. This icon aligns with its function, as it evokes the idea of discovery and exploration.

Issue: no issue found 
Severity: 0 (Not a usability problem)

### 3. User Control and Freedom:

The app ensures user control by providing clear exit options. For example, the x icon in the top-left corner of a character's details page allows users to exit the page effortlessly. Similarly, users can quickly unfavorite a character by simply clicking the filled heart icon, which returns the heart outline, making it as easy to remove favorites as it is to add them.

Issue: No clear exit option for the filter.
Severity: 4 (Usability catastrophe)
Reason: Users need the option to exit an action. Without applying options, the principle of freedom is violated to back out.

Improvements: Exit the Filter
Currently, there is no way to cancel or exit the filter once opened. Adding a clear exit option by adding an x icon at the top left of the filter pop would enhance user freedom, by allowing them to back out easily. Since the x icon is already used to exit the character detail page, incorporating it here would also reinforce consistency in the app's design and functionality. 

### 4. Consistency and Standards:

The interface maintains consistency across the app to support intuitive navigation. For instance, the heart icon next to a character image mirrors the heart icon in the navigation bar, reinforcing the connection between the two and the user's “Favorites.”
On the character list page, the search and filter options are prominently displayed at the top, making them easily discoverable. Additionally, navigation remains consistently placed at the bottom of all pages, ensuring users always know where to find it.

Issue: No search function in Favorites.
Severity: 2 (Minor usability problem).
Reason: While inconvenient for users with long favorites lists, it doesn’t block core functionality but does reduce efficiency.

Improvements: Search in Favorites
Adding a search function to the Favorites page would make it easier for users to locate a specific character, especially when the list of characters grows.

### 5. Error Prevention:

The app aims to minimize errors by guiding users. For example, a submit button in the filter dialog can be designed to remain inactive until at least one filter option is selected.

Issue: No clear feedback in the filter dialog when no options are selected.
Severity: 3 (Major usability problem)
Reason: Users may unknowingly press the Submit button without selecting options, leading to confusion or errors.

Improvements: Submit & Clear Button
- Adding a Submit button at the bottom of the filter pop-up, ensuring it can only be pressed after at least one filter option is selected.
- Including a Clear button to allow users to reset all selected filters easily.
- Adjusting the age filter so that users can leave it blank if they don’t want to filter by age.

### 6. Recognition Rather Than Recall:

The navigation icons menu is consistently visible at the bottom of the page, ensuring users can easily access key features without needing to remember their location. Additionally, the heart icons on character images clearly indicate whether a character has been favorited, eliminating the need for users to click on the character image to see if they hearted them on the details page or navigate to the favorites page to confirm their selection.

Issue: Character images lack the anime name for context.
Severity: 2 (Minor usability problem)
Reason: While it would improve usability, users can still recognize characters by their
image and find the information on the details page, so it is not critical.

Improvements: Adding Anime Name to Character Image
Displaying the character’s name alongside the anime title directly on the bottom of the image would provide additional context. This enhancement would help users easily identify and associate characters with their origins, reducing cognitive effort and improving the overall experience.

### 7. Flexibility and Efiiciency of Use:

The app supports user flexibility by providing multiple ways to perform key actions, accommodating different user preferences. For example, users can navigate back to the homepage either by clicking the home icon in the navigation bar or by tapping the DreamDex logo at the top of the page. Additionally, favoriting a character can be done directly by clicking the heart icon on the character image, or by accessing the character’s details page to learn more before favoriting them. This dual approach ensures both quick actions and informed decisions. 

Issue: no issue found 
Severity: 0 (Not a usability problem)

### 8. Aesthetic and Minimalistic Design:

The app follows a clean and minimalist design. The navigation bar includes only the most critical actions, and the overall interface is uncluttered. Characters are displayed symmetrically, creating a visually pleasing layout, while the consistent use of navy blue accents enhances cohesion.

Issue: unclear icon colors (active and inactive heart icon blend with background).
Severity: 3 (Major usability problem)
Reason: Users may struggle to recognize the status of the heart icon if its color blends with the background, impacting visibility and usability.

Improvements: Clear icon colors 
Active and inactive heart icon color will be red on character images to stand out; navy blue is not visible against the character pictures.

### 9. Help Users Recognize, Diagnose, and Recover from Errors:

If a character search yields no results, the app will display a message like “Oops we couldn’t find the character”.

Issue: No clear error message if no filter option is selected.
Severity: 3 (Major usability problem)
Reason: Users might be confused without proper feedback, leading to frustration or misinterpretation of the app’s behavior.

Improvements: Error Messages in Filter 
If users press Submit without selecting any filter options, a message like, “Select at least one filter option, or tap Cancel to exit” will be displayed. 

### 10. Help and Documentation:

The app's design is intuitive, so users may not immediately require help. However, a small, helpful guide for new users could make the experience even more welcoming.

Issue: No guide for new users.
Severity: 1 (Cosmetic problem)
Reason: While helpful, it’s not essential for most users, as the app is designed to be intuitive.

Improvements: Guides for New Users
Visibly adding a guide box at the bottom of the homepage, below the “Character of the Day.” When clicked, it could navigate users to a page with visual guides and step-by-step instructions for the app’s primary features.

### Severity Ratings:

	•	0 - Not a usability problem
	•	1 - Cosmetic problem only
	•	2 - Minor usability problem
	•	3 - Major usability problem
	•	4 - Usability catastrophe
 
----------------------------------------------------------------------------------------------------------------

# Userbility Test Plan:

## Hypothesis:

Consistent navigation placement, intuitive icons, and clear feedback mechanisms will positively impact users' ability to orient themselves within the app and complete tasks efficiently.

## Experimental Research Question:

How do consistent navigation elements and intuitive design features affect users’ ability to orient themselves and complete tasks efficiently within the app?
IV: Consistent navigation elements and intuitive design features.
DV: Users’ ability to orient themselves and complete tasks efficiently.

## Data to Collect:

### Task-based Usability Testing:

**Task 1: Details Page**

Scenario: You want to learn more about the 'Character Randomizer.'

Goal: Navigate to the details page of the 'Character Randomizer.'

Success Criteria: 
- Time on Task: time taken to locate and open the details page.
- Task completion rate: percentage of users successfully accessing the correct details page.
- Instances of pauses or confusion during navigation.

**Task 2: Search and Favorite**

Scenario: You search for “Luffy” and add him to your favorites.

Goal: Add Luffy to your Favorites and confirm that he appears in the Favorites section.

Success Criteria: 
- Time on Task: time taken to locate Luffy, favorite him, and verify in Favorites.
- Task completion rate: percentage of users successfully finding and adding Luffy to Favorites and confirming the action.
- Were users confident in searching and favoriting characters?

**Task 3: Unfavoriting a Character**

Scenario: You decide to remove “Luffy” from your Favorites.

Goal: Locate Luffy in the Favorites page and unfavorite him.

Success Criteria: 
- Time on Task: time taken to locate Luffy in Favorites and unfavorite him.
- Task completion rate: percentage of users successfully removing Luffy from Favorites.
- Did the user hesitate during the process of unfavoriting?

### Metrics and Observations:

	•	Task completion rate
	•	Time on task 
	•	User confidence
	•	User hesitation/frustration

### Execution:

Environment: They are in a quiet environment, with minimal distractions.

Participants: These tests will be conducted remotely and in-person.

Observation Tools: A stopwatch for task timing and laptop for note-taking.

Post-Task Evaluation: After each task, the participant will be asked to rate both the difficulty of completing the task and their confidence level in completing it.

System Usability Scale (SUS): After completing all tasks, participants will answer the SUS questionnaire to assess overall usability. 

### Task Evaluation Instrument: 

Difficulty: "How was the task?" (1 = Very Difficult, 7 = Very Easy)

Confidence: “How confident did you feel completing this task?” (1 = Very Confident, 7 = Very Unconfident)

### SUS: 5-point Likert scale (1 = Strongly Disagree, 5 = Strongly Agree)

1.) I think that I would like to use this system frequently.

2.) I found the system complex.

3.) I thought there was consistency in this system.

4.) I think most people would find this system difficult to learn.

5.) I felt very confident using the system.

6.) The feedback provided (e.g., icons, notifications) was not helpful.

7.) The app's design is visually appealing.

8.) The icons used in the app were difficult to understand.

9.) I always knew where I was in the app.

10.) I felt the app lacked important functionality.


# Documentation:

## Pre-Project:

### Aleks and Tiffany: 

Before the presentation of our concept, we brainstormed possible ideas and quickly agreed to focus on something related to anime, a shared interest of ours. While exploring potential directions, we noticed a gap in MyAnimeList, one of the largest anime platforms: there was no way to save or favorite individual characters. However, since MyAnimeList’s API isn’t open source, we turned to Jikan, an unofficial open-source API for MyAnimeList.

Initially, we considered expanding the concept to include characters beyond anime, but we decided to keep the app focused and straightforward. We felt this approach would better target anime enthusiasts by offering a dedicated anime character app.

## Monday, 13th January 2025

We demonstrated our idea with wireframes showcasing four main pages: a "Character of the Day" feature, a detailed character page, a browsing interface to explore the character list, and a favorites list where users can save their preferred characters.

## Tuesday, 14th – Wednesday, 15th January 2025 

On Tuesday, we began testing the Jikan API. While it provided some character data, we discovered significant limitations. Even for popular anime characters, the information was sparse, with a stronger focus on voice actors rather than character attributes. This limitation is also evident in the MyAnimeList app itself. Therefore, we turned to AniList, another anime database with more detailed character descriptions. While the level of detail varies, AniList consistently offers sufficient information for our concept.

### Aleks: 

After confirming that the API was functional and appropriate for our needs, I began developing our application, DreamDex. I integrated the API by fetching data from AniList, ensuring we could access detailed information about anime characters. It turned out to be quite a challenge, since the AniList API used the GraphQL approach instead of the familiar REST API.

### Tiffany:

I focused on designing the app’s pages and creating mockups that bring our concept to life. Rather than opting for a minimalistic approach, I chose a more vibrant and playful design to better reflect the eccentric nature of anime. The header fonts are distinctive, giving the app personality, and the background features a soft gradient design, a current design trend that adds energy and visual appeal. To maintain consistency and tie the app to the anime community, I incorporated navy blue accents throughout the design as a tribute to MyAnimeList, a platform we both like and use regularly.

## Thursday, 16th – Friday 17th January 2025

### Aleks and Tiffany:

We began developing a usability test plan to ensure the app's functionality and design met user expectations. During a heuristics evaluation of our initial mockups, we identified several key usability improvements:
- Adding a "Confirm Favoriting Action" prompt.
- Touching up the filtering options for characters.
- Including a search function within the favorites screen as well.
- Adjusting icon designs to stand out more prominently against the background.
- Displaying the anime title alongside each character name for added context.
Our user test plan aimed to assess user confidence while navigating the app. To achieve this, we measured task completion rates, observed signs of hesitation or frustration, and collected user ratings using the Single Ease Question (SEQ) to assess the perceived difficulty of each task and their confidence levels. To gather additional insights, we incorporated a System Usability Scale (SUS) evaluation, which could provide feedback beyond what task observations alone might reveal.

# Saturday, 18th  – Tuesday, 21st January 2025

### Aleks and Tiffany:

We collaborated on building the app and added a search function to the browsing page, allowing users to easily search for any character. Additionally, we implemented a favoriting feature where users can favorite a character. When a character is favorited, the heart icon changes from an outline to a filled heart, and the favorited characters are saved in the database.

However, when we began working on the Room database, we encountered a series of persistent errors. Each attempt to resolve one error seemed to generate new ones, turning what we initially thought would be a one-day task into a frustrating five-day challenge: 

### Aleks:

From Sunday through Tuesday, I repeatedly tried to fix the issue by redoing the Room database, but the same problems reappeared regardless of the approach…

By Tuesday, we realized we really needed assistance; I reached out to Mr. Oswald for help. While he was able to guide me through solving one error during a call, new errors emerged shortly afterward, leaving us still grappling with the problem.

### Tiffany: 

While Aleks was working on the Room database, I focused on adding more app features. I completed the navigation setup and added two new pages to complement the existing browsing page that displayed the character list. My primary focus was functionality over UI, so I used Jetpack icons to represent each page for clarity and simplicity. One of the new pages I started working on was the "Character of the Day" page, designed to showcase a different character daily. 

Since there were still issues with the database, we decided to switch tasks. I took over restarting the Room database setup and worked on it for the rest of Tuesday, but unfortunately, I encountered the same problems that Aleks had previously faced. 

## Wednesday, 22nd January 2025:

### Aleks and Tiffany:

Both of us had tried solutions suggested by ChatGPT and Stack Overflow, but each attempt only led to new errors.
Main Error: 
java.lang.IllegalAccessError: superclass access check failed: class org.jetbrains.kotlin.kapt3.base.javac.KaptJavaCompiler (in unnamed module @0x4f4c104b) cannot access class com.sun.tools.javac.main.JavaCompiler (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.main to unnamed module @0x4f4c104b

Explanation:
Apparently the version we were using of Kotlin wasnt compatible with JDK 16+ due to module system restrictions. The kapt was trying to access the internal Java compiler, which were no longer accessible by default in JDK 16 and above due to stricter module system. 

### Tiffany:

After one final attempt to resolve the errors in the morning, I went to the site and asked one of the tutors, Katharina, for help, and she was a lifesaver. We went through the errors together, clicking through various links and trying different solutions. We kept adjusting the dependencies, plugins, and the Kotlin version, but the same issue persisted. Eventually, we asked Alikhan, who was sitting nearby, how his Gradle setup looked. He had used the solution that Mr. Oswald had recommended—switching from kapt to ksp, a Kotlin-first alternative to kapt. With that change, the application finally worked!
Ultimately, we discovered that the root cause of the problem was the use of kapt, a Kotlin annotation processing tool, which was incompatible with our setup.
However, another problem arose… The app wasn’t able to fetch data from the AniList API, causing the character list browsing page to remain empty. Katharina showed me two effective ways to debug, which I’ll definitely use in the future: one using the break point and the other using Logcat. Katharina quickly spotted the issue: due to my lack of RAM space after the Room database was working, I had used a remote emulator instead of a virtual one. Additionally, the Nokia phone I was using was connected to Wi-Fi, which was restricting access to the API. Once I switched to hotspot, everything worked as expected.
When I hearted a character, the outline heart icon would fill, and the character was saved in the database. Unfortunately, it was saved behind the character list on the browsing page instead of the favorites page, which needed to be fixed. I, then pushed the updated database to Git.

### Aleks:

On Wednesday, I continued working on the app. We decided to switch from the ‘Character of the Day’ feature, which was complicated by tricky timestamps, to a ‘Random Character Generator’ instead. In addition to that, I focused on pagination issues: The AniList API uses pagination, so we had to implement it in our app. This led to several challenges: we couldn’t create a filtering option as it would only filter the first page, and the search function was limited to searching characters on the first page as well.
Once the database issue was resolved, I pulled the database to my branch and merged the work I had done throughout the day. Since characters weren’t being saved to the favorites screen, I was able to fix that. I also added a search function to the favorites screen, allowing users to look through their saved characters. Additionally, I created a “more characters” button to allow users to access other pages of characters.

Even though the favorite characters now appeared on the correct screen, there was still an issue: the favorite page wouldn’t refresh, so newly added characters weren’t displayed. 

For the rest of the day, I focused on collecting data for the user tests. I conducted tests with three people in person. As we’re still working on the app, we plan to incorporate the users' feedback after the presentation.

# Thursday, 23rd January 2025:

### Aleks and Tiffany:

We both went to the FH to get help with fixing the issue on the favorites screen, and once again, Katharina was a lifesaver. She helped us resolve the problem, and we also added the anime titles to the character details page, as we thought users would appreciate knowing the origin of the characters.
However, as we moved forward, we encountered another issue. When navigating to a character page after browsing from the first page of the character list, and clicking on a character to view their details, the page appeared empty. We could only access the details page from characters listed on the first page of the browsing screen, the favorites list, and the random character generator. Interestingly, if we favorited a character from the second page and viewed them in the favorites section, their information would display correctly. 

The Problem:
The issue stemmed from the fact that the home and favorites screen, both had their own ViewModel. The other screens were sharing one ViewModel, which caused the data not to be correctly passed or displayed. We realized that we needed to create separate ViewModels for each screen to ensure the correct data would be passed and shown on each page.

### Tiffany:

For the rest of the day, I focused on adding the finishing touches to the app's UI design in preparation for the final presentation. Additionally, I conducted two user tests.

### Aleks:

I worked on the presentation and continued fine-tuning the features we had implemented so far. Unfortunately, I failed to fix the Details Screen when accessing from the Home Screen after loading more characters.

----------------------------------------------------------------------------------------------------------------

# Presentation Day – APK

[Download DreamDex APK](./APK%20old/DreamDex.apk)

## Reflection – Tiffany

In hindsight, not asking for help earlier really backfired on us. We both wanted to solve the issue ourselves, but asking for help sooner would have saved us time and frustration. It turned out to be a valuable learning experience, although a frustrating one.
The API also presented some challenges. While it provided good information on the characters, the pagination issue made things more complicated. It prevented us from implementing a filtering option, and we can’t search for every character. Despite this, AniList turned out to be one of the best APIs for anime characters, so we knew it wasn't going to get any better. We just didn’t anticipate the challenges with pagination, as we hadn’t faced this issue with other APIs, but then again, they didn't have this much data.

Presenting the app to our colleagues and receiving their feedback gave us a fresh sense of motivation to continue improving the application. Mr. De Jesus helped us see our project in a new light. Initially, the limitation of only being able to pull 50 characters at a time, and being restricted to searching only within that small set, seemed like a setback. However, we realized that this challenge was actually an opportunity to enhance the experience. We decided to embrace the idea that browsing through a wide variety of characters (50 characters at a time) whether discovering new ones or finding familiar favorites, was part of the fun. In fact, our colleagues who tried out the app found it enjoyable to endlessly scroll through the characters to see which characters would be presented to them, adding an element of exploration and excitement to the experience.

## Reflection – Aleks

The workflow for the CCL3 started off smoothly, with everything progressing as planned. Challenges began; when we realized that the Jikan API did not meet our needs, forcing us to switch to the AniList API. This transition introduced struggles, as the existing code had to be refactored to accommodate GraphQL, which was a significant shift from the previous REST-based approach.
One of the biggest hurdles was pagination, as AniList’s API structure made it more complicated than expected. Handling data retrieval and ensuring switching between pages, while maintaining core functionalities became a challenge. Additionally, implementing the Room database in the second week of the CCL3 proved to be way too late, making integration difficult and adding further complexity to the project.
Despite our efforts, we were unable to fully fix the details page for characters that were not on the first page of the home screen. This limitation highlighted the need for a better approach to handling dynamic data loading and navigation.

----------------------------------------------------------------------------------------------------------------

# Post-Presentation

## Aleks and Tiffany

### Design: 

After the presentation, we continued refining the app, making significant design updates that aligned more closely with our original vision from the initial mockup.

### Column:

As endless scrolling became a key feature of the app, alongside the ability to favorite characters, we introduced a column layout option. This feature enables users to easily toggle between a two- or three-column view (the characters are displayed in card format). The button to switch layouts is conveniently placed next to the search bar for quick access.

### Search bar:

We also improved the search bar functionality. Previously, typing a letter would display any character that contained that letter somewhere in their name. Now, the search bar has been optimized to deliver more accurate results, improving the overall user experience. 

### More Characters buttons:

Previously, the 'More Characters' button was fixed at the top of the page. While this meant users didn’t need to scroll back up to load more characters, it still created an inconvenience. After pressing "Load More," the user would have to manually scroll back up to view the newly loaded list of 50 characters (since we only display 50 characters at a time).

To address this issue, we repositioned the "More Characters" button to the bottom of the character list, where it now appears as a card, just like the characters themselves. When pressed, it smoothly brings the user back to the top of the page to view the newly loaded character list. This change ensures a more seamless scrolling experience, allowing users to explore new characters without interruptions.

### Character Randomizer:

Previously, users could only access a random character by pressing the home icon. Now, we've introduced a dedicated 'Randomize' Button. With each click, users are presented with a new character.

### Troubles:

For some reason, the bottom navigation bar wouldn't display the styling we assigned to it. It was meant to have a transparent design, similar to the navbar and character detail boxes. Although the difference isn't stark, it was still frustrating not to get it fixed.

Additionally, the middle icon wouldn't display the desired icon when pressed. We ended up using the outline paper airplane icon from Jetpack, which, while not the most intuitive symbol for discovery, was chosen due to time constraints.

### User Testing:

Once we had developed an app that we were satisfied with, we proceeded with user testing. We conducted interviews with five new participants. Although we had previously tested the app with the same number of participants based on the initial mockup, we decided to discard their feedback. The concept of the app had changed since then, so their input wouldn't be as relevant. We interviewed the same group of people again.

All the interviews were conducted in person, as we had access to the appropriate mobile device for displaying the app. In-person testing proved to be more effective, as it allowed us to observe the participants' reactions and behavior in real-time. We received valuable and constructive feedback that would help us make further improvements to the app.

If this app is further developed in the future, these steps would be targeted for improvement: 
- adding the option to group favorited characters
- fixing the display of character information on the details page (particularly the issues with underscores)
- resolving the bug that prevents users from viewing the details page of characters who appear after the first page
- adding a heart icon on the details page for favoriting characters
- incorporating pagination to allow users to jump directly between different pages.
- Fixing the bottom navigation explore icon and its design

----------------------------------------------------------------------------------------------------------------

# Usability Report

[Usability Report](Usability%20Report/Usability%20Report.pdf)


