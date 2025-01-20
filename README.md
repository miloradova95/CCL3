# CCL3 DreamDex

# Members
Aleksandar Miloradovic & Tiffany Müller

# Describtion
The app allows fans and fiction enthusiasts to discover their favorite characters and save them to a personalized favorites list. Users can share their favorite characters with other fans and bond over their shared love for the most iconic figures in the world of fiction.

----------------------------------------------------------------------------------------------------------------
# Use Case
DreamDex serves as an interactive platform for anime and manga enthusiasts who wish to curate personal collections of their favourite characters. The app will utilize the AniList, as it provides detailed character data. 

The app offers a seamless experience for users to search, explore, filter, and discover characters based on various attributes. Users can view detailed information about each character, add them to personalized lists, and revisit their favorites anytime. With its engaging "Character of the Day" feature on the landing page, DreamDex ensures a fresh and dynamic user experience, encouraging users to venture beyond their existing favourites.

Designed to appeal to both casual viewers and dedicated fans, DreamDex provides an intuitive interface that simplifies character discovery and organization. Whether users aim to build a nostalgic archive, explore new series, or share their curated lists with friends, DreamDex delivers an immersive and enjoyable experience. Androids Room Database will provide a lightweight database that stores users’ personal character lists locally.

# Target Users
Anime and Manga Viewers:
Individuals who are just beginning to explore anime or manga, and seek a convenient way to learn about popular characters and series.

Dedicated Fans and Collectors:
Enthusiasts deeply invested in pop culture who want to maintain a curated collection of their favourite characters while discovering hidden gems.

Community and Social Sharers:
Fans who enjoy sharing their character preferences with friends and engaging in discussions about their collections.

----------------------------------------------------------------------------------------------------------------

# Heuristic Evaluation

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

**Task 1: Filtering**
Scenario: You want to find characters aged 30 by using the filter option.
Goal: Apply the filter to display only characters aged 30.
Success Criteria: 
- Time on Task: time taken to locate and set filter.
- Task completion rate: percentage of users successfully applying the correct age filter.
- Could the user complete this confidently?

**Task 2: Details Page**
Scenario: You want to learn more about today’s featured character.
Goal: Navigate to the details page of the "Character of the Day."
Success Criteria: 
Time on Task: time taken to locate and open the details page.
Task completion rate: percentage of users successfully accessing the correct details page.
Instances of pauses or confusion during navigation.
Task 3: Search and Favorite
Scenario: You search for “Luffy” and add him to your favorites.
Goal: Add Luffy to your Favorites and confirm that he appears in the Favorites section.
Success Criteria: 
Time on Task: time taken to locate Luffy, favorite him, and verify in Favorites.
Task completion rate: percentage of users successfully finding and adding Luffy to Favorites and confirming the action.
Were users confident in searching and favoriting characters?
Task 4: Unfavoriting a Character
Scenario: You decide to remove “Luffy” from your Favorites.
Goal: Locate Luffy in the Favorites section and unfavorite him.
Success Criteria: 
Time on Task: time taken to locate Luffy in Favorites and unfavorite him..
Task completion rate: percentage of users successfully removing Luffy from Favorites.
Did the user hesitate during the process of unfavoriting?
Task 5: Guide for Beginners
Scenario: You’re a new user and want to find a guide that explains how to use the app.
Goal: Locate and access the “Guide for Beginners”.
Success Criteria: 
Time on Task: time taken to locate the guide.
Task completion rate: percentage of users successfully finding and opening the guide.
Did the user find the guide easily confidentally?
*This step is last to assess if users were able to complete the previous tasks without needing external help or guidance.
Metrics and Observations:
Task completion rate
Time on task 
User confidence
User hesitation/frustration



