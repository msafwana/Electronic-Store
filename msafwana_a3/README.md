# CIS2430-A3

## INTRODUCTION
The intention of the program is to hold multiple kind of products in particular books and electronic in a single arraylist name productsList. It allows the user to add and search for them online. To identify each product in the eStore uniquely they have unique product IDs. The store will typically display ID, price, author, year, description and publisher for book whereas for electronic item it will display maker, price, year, ID and description. The program is more interactive an cleaner through the GUI program

## LIMITATIONS OF THE PROGRAM
- When entering the price the input should be in the form of integer or double values. Eg 1234 or 123.45 but NOT $123 or $12.45. ONLY numbers as input.

- When you run the program you will see a popup of java frame on your taskbar click on that and maximize the frame since it will not do it automatically

- Choose a command you would like to perform. If you choose "Add a product" please select the type of product as "Book" or "electronic" it is a MUST to select the product type prior to filling up information

- Example if product type "Book" was selected, enter the required fields and hit enter. Before adding another "Book" product please hit reset!

- For Example you selected type as "Book" and added couple of books, to add "Electronic" go to the command menu and click on "Add a product". Once you get a new frame select the product type as "Electronic" and add the required fields.

- If you want to close a fram hit the "x" mark on the JFRAME on top right corner. If you click "Quit program" from the commands it will quit the program all togehter.



## USER GUIDE/INFORMATION
All required gradle files as well as java files have been zipped under the name msafwan_a2.zip
- Unzip the folder
- The pacakage name is eStoreSearch
- Run gradle build 
- It should build successfully with no errors or warnings
- Execute gradle run

## JUNIT

There are couple of Junit tests to check if accessors and mutators work. It explicitly adds each string (description, author, price, productID, publisher) one at a time to test if a match is found or not. There are couple test to see if a new book is added if publisher and author is empty. The same test follows for electronic productsList while the maker is empty.
There are couple of test done to find if the keywords from the description is split and stored in token and to see if a match is found to display all the books with the required keyword, that happens for assertTrue when the match is found and assertFalse when the match is not found. The functionality of adding description keywords and searching keywords from hashmap have been done. There are also test done to write to file from arraylist and copy to arraylist to textfile. This will create a textfile named "file.txt" under "./src/test/resources/file.txt"

Ex. String Vdescription = "Java programming"; 
    The Vdescription is the description of the book

    String keyWord[] = Vdescription.split("");
    We split the description by white spaces to store keyWord[0] as Java and keyWord[1] as programming

    String falsedescription = "Different description";
    String keyWord2[] = falsedescription.split("");

    The same procedure followings for the above two parameters.

    assertFalse(testObj.matchKey(keyWord2,Vdescription));
    KeyWord2 stores "different" "description" which finds not match in Vdescription
    assertTrue(testObj.matchKey(keyWord,Vdescription));
    KeyWord stores "Java" "programming" which finds  match in Vdescription

To run the tests
```java
gradle build
gradle test
```

## RUN PROGRAM

```java
gradle build
gradle run
```
## FUTURE IMPROVMENTS

- Give more chances to user incase of a mistake on textfield so the user could use backspace instead of resetting all the fields
- More aesthetically pleasing GUI
- Better modularity in coding style
- Improve on how to integrate functions with GUI. 
- NOTE: My hashmap search works perfectly well when not called in GUI. I even got a 100 on Assignment 2.. However i could not intergate my hashmap search properly with the GUI.