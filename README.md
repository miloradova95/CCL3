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
**1. Visibility of System Status:**

The bottom menu navigation includes icons that inform users about their current location within the app. When a user navigates to a page, the corresponding icon transitions from an outlined icon to a filled icon, providing clear visual feedback about the selected page. This design ensures users always know where they are in the app.

Issue: No confirmation when favoriting/unfavoriting characters.
Severity: 2 (minor usability problem)
Reason: Users may feel uncertain if their input was registered, leading to confusion or repeated actions. The immediate feedback by the heart icon getting filled when a character is favorited might be too small to notice.

Improvements: Confirm Favoriting Action
Displaying a small and short confirmation message like "Added to Favorites" or “Removed from Favorites” when the user clicks the heart icon to favorite or unfavorite character. This feedback reinforces the action and assures users that their input was successful. 

**2. Match Between System and the Real World:**

We selected intuitive icons to align with users' real-world expectations. For example:
- The house icon represents the home screen, a universally understood metaphor.
- When a user clicks on a character's image, they are taken to a detailed view. Adjacent to the image, a heart icon allows users to favorite the character. The outlined heart becomes filled when tapped, providing immediate feedback that the character has been saved. 
- To view their favorites, users can tap the heart icon located in the bottom navigation bar. Since this icon mirrors the one used for favoriting characters, users can easily make the connection. The use of a heart icon aligns with real-world associations, where hearts are intuitively connected to concepts of liking or saving cherished items.
- The x icon in the top-left corner of the details page provides a simple, universally recognized way to close the page and return to the previous screen.
- The globe icon represents the explore feature, which displays a list of characters. This icon aligns with its function, as it evokes the idea of discovery and exploration.

Issue: no issue found 
Severity: 0 (Not a usability problem)

**3. User Control and Freedom:**

The app ensures user control by providing clear exit options. For example, the x icon in the top-left corner of a character's details page allows users to exit the page effortlessly. Similarly, users can quickly unfavorite a character by simply clicking the filled heart icon, which returns the heart outline, making it as easy to remove favorites as it is to add them.

Issue: No clear exit option for the filter.
Severity: 4 (Usability catastrophe)
Reason: Users need the option to exit an action. Without applying options, the principle of freedom is violated to back out.

Improvements: Exit the Filter
Currently, there is no way to cancel or exit the filter once opened. Adding a clear exit option by adding an x icon at the top left of the filter pop would enhance user freedom, by allowing them to back out easily. Since the x icon is already used to exit the character detail page, incorporating it here would also reinforce consistency in the app's design and functionality. 

**4. Consistency and Standards:**

The interface maintains consistency across the app to support intuitive navigation. For instance, the heart icon next to a character image mirrors the heart icon in the navigation bar, reinforcing the connection between the two and the user's “Favorites.”
On the character list page, the search and filter options are prominently displayed at the top, making them easily discoverable. Additionally, navigation remains consistently placed at the bottom of all pages, ensuring users always know where to find it.

Issue: No search function in Favorites.
Severity: 2 (Minor usability problem).
Reason: While inconvenient for users with long favorites lists, it doesn’t block core functionality but does reduce efficiency.

Improvements: Search in Favorites
Adding a search function to the Favorites page would make it easier for users to locate a specific character, especially when the list of characters grows.



