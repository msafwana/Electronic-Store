package eStoreSearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.time.Year;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.TextUI;

public class GUI extends JFrame {

  public static final int WIDTH = 1280;
  public static final int HEIGHT = 720;
  private JFrame frame;
  private JTextArea firstmessageJTextArea;
  private JPanel firstPanel;
  private JPanel secondPanel;
  private JPanel thirdPanel;
  private JLabel welcomemsg;
  private JLabel programmsg;
  private JMenu impMenu;
  private JMenuBar command;
  private JMenuItem add, search, quit;
  private JComboBox producttype;
  private JPanel mainaddpanel;
  private JPanel mainsearchpanel;
  private JPanel addPanel;
  private JPanel searchPanel;
  private JPanel messagedisp;
  private JPanel impbuttons;
  private JLabel prodcutID;
  private JLabel Description;
  private JLabel DescriptionKey;
  private JLabel Price;
  private JLabel Year;
  private JLabel StartYear;
  private JLabel EndYear;
  private JLabel Authors;
  private JLabel Publisher;
  private JLabel Makers;
  private JLabel messages;
  private JTextField forProductID;
  private JTextField forDescription;
  private JTextField forDescriptionKey;
  private JTextField forPrice;
  private JTextField forYear;
  private JTextField forStartYear;
  private JTextField forEndYear;
  private JTextField forAuthors;
  private JTextField forPublisher;
  private JTextField forMakers;
  private JTextArea textArea;
  private JScrollPane scroll;
  private JButton enter;
  private JButton reset;

  private String proid;
  private String description;
  private String price = "0.00";
  private String year;
  private String authors;
  private String publisher;
  private String makers;
  private Integer yearVal;
  boolean isproidcheck = false;

  EStoreSearch eSearch = new EStoreSearch();
  Product product = null;

  public boolean isNullOrEmpty(String str) {
    if (str != null && !str.isEmpty()) return false;
    return true;
  }

  public boolean checkProductID(String productID) {
    if (productID.length() == 6 && productID.matches("[0-9]+")) return false;
    return true;
  }

  public void checkconditionsandadd( String idcheck, String descheck, Integer yearVal, String year, String price, String authors, String publisher) {
    if (yearVal < 1000 || yearVal > 9999) {
      textArea.setText( "Enter the year (between 1000 and 9999) the book was published" );
    }
    if (!isNullOrEmpty(proid) && !isNullOrEmpty(description) && !isNullOrEmpty(year) && (yearVal > 1000 || yearVal < 9999) && !checkProductID(proid)) {
      textArea.setText("");
      try {
              product = new Book(price, year, descheck, publisher, authors, idcheck);
            
              eSearch.addProductToList(product);
              eSearch.addToHashMap(descheck);

    } catch (Exception e) {

      textArea.setText("ERROR: Product could not be added \n");
    }
      textArea.append(
        "Book has been added successfully!" + "\n" + product.toString()
      );
    }
  }

  public void checkconditionsandaddElec(String idcheck, String descheck, Integer yearVal, String year, String price, String maker
  ) {
    if (yearVal < 1000 || yearVal > 9999) {
      textArea.setText(
        "Enter the year (between 1000 and 9999) the book was published"
      );
    }
    if (!isNullOrEmpty(proid) && !isNullOrEmpty(description) && !isNullOrEmpty(year) &&
        (yearVal > 1000 || yearVal < 9999) && !checkProductID(proid)) {
      textArea.setText("");
      try {
        product = new Electronics( price, year, description, makers, proid);

      } catch (Exception exception) {

        textArea.setText("ERROR: ELECTRONIC product could not be added");
      }
      textArea.append( "Electronic has been added successfully!" + "\n" + product.toString());
    }
  }

  public void resetTextfieldAdd() {
    forProductID.setText("");
    forDescription.setText("");
    forPrice.setText("");
    forYear.setText("");
    forAuthors.setText("");
    forPublisher.setText("");
    textArea.setText("");
  }

  public void resetTextfieldAddElec() {
    forProductID.setText("");
    forDescription.setText("");
    forPrice.setText("");
    forYear.setText("");
    forMakers.setText("");
  }

  public void resetTextfieldSearch() {
    forProductID.setText("");
    forDescriptionKey.setText("");
    forStartYear.setText("");
    forEndYear.setText("");
    textArea.setText("");
  }

  public void addpanel() {
    frame = new JFrame();
    frame.setLayout(new BorderLayout());

    mainaddpanel = new JPanel();
    mainaddpanel.setLayout(new GridLayout(3, 1));
    //mainaddpanel.setLayout(new BorderLayout());

    addPanel = new JPanel();
    addPanel.setLayout(new GridLayout(7, 1, 10, 10));
    //addPanel.setLayout(new BoxLayout());
    //  addPanel.setBorder(BorderFactory.createEmptyBorder(80, 10, 80, 80));
    addPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    //addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));

    prodcutID = new JLabel("ProductID: ");
    prodcutID.setFont(new Font("Arial", Font.BOLD, 17));
    forProductID = new JTextField(20);
    forProductID.setMaximumSize(forProductID.getPreferredSize());

    Description = new JLabel("Description: ");
    Description.setFont(new Font("Arial", Font.BOLD, 17));
    forDescription = new JTextField(20);
    forDescription.setMaximumSize(forDescription.getPreferredSize());

    Price = new JLabel("Price: ");
    Price.setFont(new Font("Arial", Font.BOLD, 17));
    forPrice = new JTextField(10);
    forPrice.setMaximumSize(forPrice.getPreferredSize());

    Year = new JLabel("Year: ");
    Year.setFont(new Font("Arial", Font.BOLD, 17));
    forYear = new JTextField(10);
    forYear.setMaximumSize(forYear.getPreferredSize());

    Authors = new JLabel("Authors: ");
    Authors.setFont(new Font("Arial", Font.BOLD, 17));
    forAuthors = new JTextField(20);
    forAuthors.setMaximumSize(forAuthors.getPreferredSize());

    Publisher = new JLabel("Publisher: ");
    Publisher.setFont(new Font("Arial", Font.BOLD, 17));
    forPublisher = new JTextField(20);
    forPublisher.setMaximumSize(forPublisher.getPreferredSize());

    Makers = new JLabel("Maker: ");
    Makers.setFont(new Font("Arial", Font.BOLD, 17));
    forMakers = new JTextField(20);
    forMakers.setMaximumSize(forMakers.getPreferredSize());

    addPanel.add(prodcutID);
    addPanel.add(forProductID);

    addPanel.add(Description);
    addPanel.add(forDescription);

    addPanel.add(Price);
    addPanel.add(forPrice);

    addPanel.add(Year);
    addPanel.add(forYear);

    addPanel.add(Authors);
    addPanel.add(forAuthors);

    addPanel.add(Publisher);
    addPanel.add(forPublisher);

    addPanel.add(Makers);
    addPanel.add(forMakers);

    addPanel.setBorder(BorderFactory.createTitledBorder("Adding Products"));
    addPanel.setBorder(
      BorderFactory.createTitledBorder(null, "Adding Products", TitledBorder.DEFAULT_POSITION, TitledBorder.LEFT, new Font("Arial", Font.BOLD, 16)));

    impbuttons = new JPanel();

    Box box = Box.createVerticalBox();

    enter = new JButton("          Enter           ");
    enter.setPreferredSize(new Dimension(200, 200));
    box.add(enter);

    reset = new JButton("          Reset          ");
    box.add(reset);

    impbuttons.add(box);
    impbuttons.setBorder( BorderFactory.createTitledBorder( "Button to ENTER or RESET the product fields" ));
  
    final JPanel type = new JPanel();
    type.setLayout(new GridLayout(1, 2, 90, 90));

    final JLabel typeinfo = new JLabel("Product Type: ");
    typeinfo.setFont(new Font("Arial", Font.BOLD, 17));
    type.add(typeinfo);
    producttype = new JComboBox();
    producttype.setFont(new Font("Arial", Font.BOLD, 16));

    producttype.addItem("Book");
    producttype.addItem("Electronic");
    type.add(producttype);
    producttype.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String items = (String) producttype.getSelectedItem(); //get the selected item
          switch (items) { //check for a match
            case "Book":
              System.out.println("In bookcase");

              Description.setVisible(true);
              prodcutID.setVisible(true);
              Price.setVisible(true);
              Publisher.setVisible(true);
              Authors.setVisible(true);
              forProductID.setVisible(true);
              forDescription.setVisible(true);
              forPrice.setVisible(true);
              forPublisher.setVisible(true);
              forAuthors.setVisible(true);
              Makers.setVisible(false);
              forMakers.setVisible(false);

              enter.addActionListener(
                new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                    if (!enter.getModel().isPressed()) {
                      proid = forProductID.getText();
                      description = forDescription.getText();
                      price = forPrice.getText();
                      year = forYear.getText();
                      authors = forAuthors.getText();
                      publisher = forPublisher.getText();

                    try{
                      if (isNullOrEmpty(proid)) {
                        textArea.setText(
                          "ProductID cannot be empty. Please enter a valid productID"
                        );
                      }

                      if (checkProductID(proid)) {
                        textArea.setText(
                          "ProductID must be 6 digits only and numerical"
                        );
                      }

                      if (eSearch.checkuniqueID(proid)) {
                        textArea.setText("ProductID is taken");
                      }

                      if (isNullOrEmpty(description)) {
                        textArea.setText(
                          "Description cannot be empty. Please enter a valid description"
                        );
                      }
                      if (isNullOrEmpty(year)) {
                        textArea.setText(
                          "Year cannot be empty. Please enter a valid description"
                        );
                      }
                      try {
                        yearVal = Integer.valueOf(year);
                      } catch (Exception exp) {
                        if (yearVal < 1000 || yearVal > 9999) {
                          textArea.setText(
                            "Enter the year (between 1000 and 9999) the book was published"
                          );
                        }
                      }
                      if (yearVal < 1000 || yearVal > 9999) {
                        textArea.setText(
                          "Enter the year (between 1000 and 9999) the book was published"
                        );
                      }
                    }catch (NullPointerException E) {
                      System.out.println("Empty fields. Please enter a valid input");
                    }
                      if ( !isNullOrEmpty(proid) &&
                           !isNullOrEmpty(description) &&
                           !isNullOrEmpty(year) &&
                           (yearVal > 1000 || yearVal < 9999) &&
                           !checkProductID(proid)
                         ) {
                        textArea.setText("");
                        try {
                                product = new Book(price, year, description, publisher, authors, proid );
                                
                      } catch (Exception exception) {

                        textArea.setText("ERROR: Product could not be added \n");
                      }
                      try {
                        eSearch.addProductToList(product);
                      } catch (Exception exception) {
                        textArea.setText("ERROR: Cannot add product to list");
                      }
                        eSearch.addToHashMap(description);

                        textArea.append( "Book has been added successfully!" + "\n" + product.toString() );
                      }
                    }
                  }
                }
              );

              reset.addActionListener(
                new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                    if (!reset.getModel().isPressed()) {
                      resetTextfieldAdd();
                    }
                  }
                }
              );

              break;
            case "Electronic":
              System.out.println("In Electroniccase");

              prodcutID.setVisible(true);
              Description.setVisible(true);
              Price.setVisible(true);
              Publisher.setVisible(false);
              Authors.setVisible(false);
              forProductID.setVisible(true);
              forDescription.setVisible(true);
              forPrice.setVisible(true);
              forPublisher.setVisible(false);
              forAuthors.setVisible(false);
              Makers.setVisible(true);
              forMakers.setVisible(true);

              enter.addActionListener(
                new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                    if (!enter.getModel().isPressed()) {

                      proid = forProductID.getText();
                      description = forDescription.getText();
                      price = forPrice.getText();
                      year = forYear.getText();
                      makers = forMakers.getText();

                    try {
                      if (isNullOrEmpty(proid)) {
                        textArea.setText(
                          "ProductID cannot be empty. Please enter a valid productID"
                        );
                      }

                      if (checkProductID(proid)) {
                        textArea.setText(
                          "ProductID must be 6 digits only and numerical"
                        );
                      }

                      if (eSearch.checkuniqueID(proid)) {
                        textArea.setText("ProductID is taken");
                      }

                      if (isNullOrEmpty(description)) {
                        textArea.setText(
                          "Description cannot be empty. Please enter a valid description"
                        );
                      }
                      if (isNullOrEmpty(year)) {
                        textArea.setText(
                          "Year cannot be empty. Please enter a valid description"
                        );
                      }
                      try {
                        yearVal = Integer.valueOf(year);
                      } catch (Exception exp) {
                        if (yearVal < 1000 || yearVal > 9999) {
                          textArea.setText(
                            "Enter the year (between 1000 and 9999) the book was published"
                          );
                        }
                      }
                     

                      if (yearVal < 1000 || yearVal > 9999) {
                        textArea.setText(
                          "Enter the year (between 1000 and 9999) the book was published"
                        );
                      }

                    }catch (NullPointerException exception) {
                      System.out.println("Empty fields. Please enter a valid input \n");
                    }
                      if (
                        !isNullOrEmpty(proid) &&
                        !isNullOrEmpty(description) &&
                        !isNullOrEmpty(year) &&
                        (yearVal > 1000 || yearVal < 9999) &&
                        !checkProductID(proid)
                      ) {
                        textArea.setText("");
            
                        try {
                              product = new Electronics( price, year, description, makers, proid);

                        } catch (Exception exception) {
                              textArea.setText("ERROR: ELECTRONIC product could not be added");
                        }

                        try {
                              eSearch.addProductToList(product);
                        } catch (Exception exception) {
                              textArea.setText("ERROR: Cannot add product to list");
                        }
                        eSearch.addToHashMap(description);

                      
                        textArea.append( "Electronic has been added successfully!" + "\n" + product.toString());
                      }
                    }
                  }
                }
              );
              reset.addActionListener(
                new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                    if (!reset.getModel().isPressed()) {
                      resetTextfieldAddElec();
                    }
                  }
                }
              );
              break;
          }
        }
      }
    );

    messagedisp = new JPanel();
    messagedisp.setLayout(new BorderLayout());
    //  messagedisp.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
    messages = new JLabel("Messages");
    messages.setFont(new Font("Arial", Font.BOLD, 17));
    messages.setHorizontalAlignment(JLabel.CENTER);

    textArea = new JTextArea();
    scroll = new JScrollPane(textArea);

    scroll.setVerticalScrollBarPolicy(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
    );
    scroll.setHorizontalScrollBarPolicy(
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );

    // messagedisp.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
    messagedisp.add(messages, BorderLayout.NORTH);
    messagedisp.add(scroll, BorderLayout.CENTER);

    mainaddpanel.add(addPanel, BorderLayout.CENTER);
    mainaddpanel.add(impbuttons, BorderLayout.LINE_END);
    mainaddpanel.add(messagedisp, BorderLayout.PAGE_END);

    command = new JMenuBar();
    impMenu = new JMenu(" Commands");
    impMenu.setFont(new Font("Arial", Font.BOLD, 18));

    add = new JMenuItem("Add an product");
    add.setFont(new Font("Arial", Font.BOLD, 18));
    add.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    add.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          addpanel();
          System.out.println("Going to add");
        }
      }
    );
    impMenu.add(add);

    impMenu.addSeparator();

    search = new JMenuItem("Search for an product");
    //    search = impMenu.add("Search for a product");
    search.setFont(new Font("Arial", Font.BOLD, 18));
    search.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    search.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          searchpanel();
          System.out.println("Going to search");
        }
      }
    );
    // search.addActionListener(new commandListener());
    impMenu.add(search);

    impMenu.addSeparator();

    quit = new JMenuItem("Quit the program");
    quit.setFont(new Font("Arial", Font.BOLD, 18));
    quit.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    // quit.addActionListener(new commandListener());
    quit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );
    impMenu.add(quit);
    //quit = impMenu.add("Quit");

    command.add(impMenu);

    frame.setJMenuBar(command);

    frame.add(mainaddpanel);
    frame.add(type, BorderLayout.NORTH);

    //addPanel.setVisible(true);
    messagedisp.setVisible(true);
    frame.setVisible(true);
    frame.pack();
  }

  public void searchpanel() {
    frame = new JFrame();
    frame.setLayout(new BorderLayout());

    mainsearchpanel = new JPanel();
    mainsearchpanel.setLayout(new GridLayout(3, 1));
    //mainaddpanel.setLayout(new BorderLayout());

    searchPanel = new JPanel();
    searchPanel.setLayout(new GridLayout(4, 1, 30, 30));
    
    prodcutID = new JLabel("ProductID: ");
    prodcutID.setFont(new Font("Arial", Font.BOLD, 17));
    forProductID = new JTextField(20);
    forProductID.setMaximumSize(forProductID.getPreferredSize());

    DescriptionKey = new JLabel("Description Keywords: ");
    DescriptionKey.setFont(new Font("Arial", Font.BOLD, 17));
    forDescriptionKey = new JTextField(20);
    forDescriptionKey.setMaximumSize(forDescriptionKey.getPreferredSize());

    StartYear = new JLabel("Start Year: ");
    StartYear.setFont(new Font("Arial", Font.BOLD, 17));
    forStartYear = new JTextField(10);
    forStartYear.setMaximumSize(forStartYear.getPreferredSize());

    EndYear = new JLabel("End Year: ");
    EndYear.setFont(new Font("Arial", Font.BOLD, 17));
    forEndYear = new JTextField(10);
    forEndYear.setMaximumSize(forEndYear.getPreferredSize());

    searchPanel.add(prodcutID);
    forProductID.setBorder(BorderFactory.createLoweredBevelBorder());
    searchPanel.add(forProductID);

    searchPanel.add(DescriptionKey);
    forDescriptionKey.setBorder(BorderFactory.createLoweredBevelBorder());
    searchPanel.add(forDescriptionKey);

    searchPanel.add(StartYear);
    forStartYear.setBorder(BorderFactory.createLoweredBevelBorder());
    searchPanel.add(forStartYear);

    searchPanel.add(EndYear);
    forEndYear.setBorder(BorderFactory.createLoweredBevelBorder());
    searchPanel.add(forEndYear);

    searchPanel.setBorder( BorderFactory.createTitledBorder("Searching Products"));
    searchPanel.setBorder( BorderFactory.createTitledBorder( null,"Searching Products", TitledBorder.DEFAULT_POSITION, TitledBorder.LEFT, new Font("Arial", Font.BOLD, 16)) );
    searchPanel.setFont(new Font("Arial", Font.BOLD, 16));
    impbuttons = new JPanel();

    Box box = Box.createVerticalBox();

    enter = new JButton("          Enter           ");
    enter.setBorder(BorderFactory.createLoweredBevelBorder());

    box.add(enter);

    reset = new JButton("          Reset          ");
    reset.setBorder(BorderFactory.createLoweredBevelBorder());
    box.add(reset);

    impbuttons.add(box);
    impbuttons.setBorder( BorderFactory.createTitledBorder( "Button to ENTER or RESET the product fields"));

    enter.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!enter.getModel().isPressed()) {
            if (EStoreSearch.productsList.isEmpty()) {
            textArea.setText( "There are no products in the list" );
            }
            proid = forProductID.getText();
            description = forDescription.getText();
            price = forPrice.getText();
            year = forYear.getText();
            authors = forAuthors.getText();
            publisher = forPublisher.getText();
    

            if (proid != "" || year != "" || description != "") {
              textArea.append(EStoreSearch.searchHashMapGUI(description));
            } else {
              textArea.append( "The product list is: " + "\n" + EStoreSearch.printproductsLisGUIt() + "\n");
            }
          }
        }
      }
    );
    reset.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!reset.getModel().isPressed()) {
            resetTextfieldSearch();
          }
        }
      }
    );
    //impbuttons.add(reset);

    messagedisp = new JPanel();
    messagedisp.setLayout(new BorderLayout());
    //  messagedisp.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
    messages = new JLabel("Search Results");
    messages.setFont(new Font("Arial", Font.BOLD, 17));
    messages.setHorizontalAlignment(JLabel.CENTER);

    textArea = new JTextArea();
    scroll = new JScrollPane(textArea);

    scroll.setVerticalScrollBarPolicy(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
    );
    scroll.setHorizontalScrollBarPolicy(
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );

    // messagedisp.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
    messagedisp.add(messages, BorderLayout.NORTH);
    messagedisp.add(scroll, BorderLayout.CENTER);

    mainsearchpanel.add(searchPanel, BorderLayout.CENTER);
    mainsearchpanel.add(impbuttons, BorderLayout.LINE_END);
    mainsearchpanel.add(messagedisp, BorderLayout.PAGE_END);

    command = new JMenuBar();
    impMenu = new JMenu(" Commands");
    impMenu.setFont(new Font("Arial", Font.BOLD, 18));

    add = new JMenuItem("Add an product");
    add.setFont(new Font("Arial", Font.BOLD, 18));
    add.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    add.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          addpanel();
          System.out.println("Going to add");
        }
      }
    );
    impMenu.add(add);

    impMenu.addSeparator();

    search = new JMenuItem("Search for an product");
    //    search = impMenu.add("Search for a product");
    search.setFont(new Font("Arial", Font.BOLD, 18));
    search.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    search.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          searchpanel();
          System.out.println("Going to search");
        }
      }
    );
    // search.addActionListener(new commandListener());
    impMenu.add(search);

    impMenu.addSeparator();

    quit = new JMenuItem("Quit the program");
    quit.setFont(new Font("Arial", Font.BOLD, 18));
    quit.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    // quit.addActionListener(new commandListener());
    quit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );
    impMenu.add(quit);
    //quit = impMenu.add("Quit");

    command.add(impMenu);

    frame.setJMenuBar(command);

    frame.add(mainsearchpanel);

    //addPanel.setVisible(true);
    messagedisp.setVisible(true);
    frame.setVisible(true);
    frame.pack();
  }

  public void firstwindows() {
    final String welcomemessage;
    final String programmessage;

    programmessage = "<html> The EStoreSearch program </html>";
    welcomemessage =
      "<html> Welcome to eStoreSearch <br> <br> Choose a \"Commands\" from the Commands menu above for adding a product, searching products, or quitting the program </html> ";

    thirdPanel = new JPanel();
    welcomemsg = new JLabel(welcomemessage);
    programmsg = new JLabel(programmessage);
    welcomemsg.setFont(new Font("Arial", Font.BOLD, 24));
    welcomemsg.setAlignmentX(TOP_ALIGNMENT);
    //thirdPanel.setLayout(new BorderLayout());
    thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.X_AXIS));
    // firstPanel.setVisible(true);
    welcomemsg.setHorizontalAlignment(JLabel.CENTER);
    welcomemsg.setVerticalAlignment(JLabel.CENTER);
    thirdPanel.add(welcomemsg, SwingConstants.CENTER);
    add(thirdPanel);

    command = new JMenuBar();
    impMenu = new JMenu(" Commands");
    impMenu.setFont(new Font("Arial", Font.BOLD, 18));

    add = new JMenuItem("Add an product");
    add.setFont(new Font("Arial", Font.BOLD, 18));
    add.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    add.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          addpanel();
          System.out.println("Going to add");
        }
      }
    );
    impMenu.add(add);

    impMenu.addSeparator();

    search = new JMenuItem("Search for an product");
    //    search = impMenu.add("Search for a product");
    search.setFont(new Font("Arial", Font.BOLD, 18));
    search.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    search.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          searchpanel();
          System.out.println("Going to search");
        }
      }
    );
    // search.addActionListener(new commandListener());
    impMenu.add(search);

    impMenu.addSeparator();

    quit = new JMenuItem("Quit the program");
    quit.setFont(new Font("Arial", Font.BOLD, 18));
    quit.setPreferredSize(new Dimension(700, add.getPreferredSize().height));
    // quit.addActionListener(new commandListener());
    quit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );
    impMenu.add(quit);
    //quit = impMenu.add("Quit");

    command.add(impMenu);

    setJMenuBar(command);
  }


  public GUI() {
    super();
    frame = new JFrame();
    setTitle("eStoreSearch");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.getContentPane().setBackground(Color.gray);
    //frame.setVisible(true);
    firstwindows();
  }


  public static void main(String[] args) {
   
    EStoreSearch eSearch = new EStoreSearch();
    String filename = args[0];
    eSearch.saveToFile(filename);
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new GUI().setVisible(true);
        }
      }
    );
  }
}
