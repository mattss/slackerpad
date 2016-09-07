/* Matthew Sital-Singh
   ms1473
   COMS12100 Assignment: Scene
*/

/** Slackwords.java
    Holds various information used by the Slackpad class
*/

public class Slackwords {

    /** Returns the readme text string
        @return readme text string
     */
    public String getReadme() {
        return readmeText;
    }

    /** Gets the names of all the predefined
        'stories' in this file
        @return String array of names
    */
    public String[] getNames() {
        String[] tmp = new String[stories.length];
        for (int i=0; i<stories.length; i++) {
            tmp[i] = stories[i][0];
        }
        return tmp;
    }

    /** Returns the Story with the title
        specified (or an empty string if not found
        @param title the name of the story
        @return the story (or "" if none found
    */
    public String getStory(String story) {
        for (int i=0; i<stories.length; i++) {
            if (stories[i][0].equals(story))
                return stories[i][1];
        }
        return "";
    }

    /** The story array */
    private String[][] stories = {
        { "How to make a cup of tea",
          "How to make a cup of tea\n" +
          "\n" +
          "First, you need fresh water.\n" +
          "Pour out the water in the kettle from the day before.\n" +
          "Pour in some fresh water from your preferred source.\n" +
          "I use filtered tap water and am please with the result.\n" +
          "\n" +
          "Place the kettle on the stove get the heat going.\n" +
          "Do not watch it.  A watched kettle will not boil.\n" +
          "\n" +
          "While the water is boiling, prepare the rest of the gear.\n" +
          "You will need a teapot, a cup, a strainer, a teaspoon, and your favorite tea.\n" +
          "Note my excellent teapot.  It\'s Japanese and I got it for a steal on eBay.\n" +
          "\n" +
          "Good tea does not come in tea bags.\n" +
          "Good tea is loose and keep in a sealed container tin.\n" +
          "I get my tea from Golden Moon Tea.  They have the good stuff.\n" +
          "\n" +
          "Now here is the tricky part.\n" +
          "You need to measure out a heaping teaspoon of tea and put it in the strainer holder.\n" +
          "Isn\'t it amazing that the teaspoon holds exactly the right amount of tea for a cup of tea.\n" +
          "If you are making more than one cup of tea, then you should put in one teaspoon per cup.\n" +
          "Some mention adding another teaspoon of tea \'for the pot\', but I haven\'t found it necessary.\n" +
          "\n" +
          "Some people like to use teabags to skip all this,\n" +
          "but that would be wrong.\n" +
          "This poor woman is briefly dipping her crappy teabag\n" +
          "\n" +
          "Next, you need to warm up your teapot.  You want to make sure that the\n" +
          "hot water used to brew your tea stays hot.  To ensure this, you want to warm up\n" +
          "the teapot with a little hot water before you begin to brew.\n" +
          "\n" +
          "Just swish it around the teapot for a few seconds and then dump it out.\n" +
          "The teapot should feel warm.\n" +
          "\n" +
          "Now you are ready to put the tea in the pot.\n" +
          "Just dump it in.\n" +
          "\n" +
          "Now pour in the hot water.  About a cup more that you are going to drink.\n" +
          "\n" +
          "The tea is now steeping in the pot.\n" +
          "I let mine steep for about a minute.\n" +
          "Too long, and the tea will be quite bitter.\n" +
          "\n" +
          "A few crazy types enjoy their tea with the leaves in the cup.\n" +
          "These people are, of course, crazy.\n" +
          "Use a small strainer to catch the tea leaves before they enter your cup.\n" +
          "\n" +
          "The cooking is complete.\n" +
          "You have successful made a cup of tea.\n" +
          "\n" +
          "All that\'s left is to sit down with the morning paper and enjoy your tasty beverage.\n" },

        { "Women Speek",
          "\"Women Speek\"\n\n" +
          "1. \"Fine\"\n" +
          "\n" +
          "This is the word a woman uses at the end of any argument that they feel they are right about but need to shut you up. \n" +
          "NEVER use fine to describe how a woman looks. This will cause you to have one of those arguments.\n" +
          "\n" +
          "2. \"Five minutes\"\n" +
          "\n" +
          "This is half an hour. \n" +
          "It is equivalent to the five minutes that your football game is going to last before you take out the rubbish, \n" +
          "so they feel that it's an even trade.\n" +
          "\n" +
          "3. \"Nothing\"\n" +
          "\n" +
          "This means something and you should be on your toes. \"Nothing\" is usually used to describe \n" +
          "the feeling a woman has of wanting to turn you inside out, upside down, backwards, or all three. \n" +
          "\"Nothing\" usually signifies an argument that will last \"Five Minutes\" and end with the word \"Fine\".\n" +
          "\n" +
          "4. \"Go Ahead\" (with raised eyebrows):\n" +
          "\n" +
          "This is a dare. One that will result in a woman getting upset over \"Nothing\" and will end with the word \"Fine\".\n" +
          "\n" +
          "5. \"Go Ahead\" (normal eyebrows):\n" +
          "\n" +
          "This means, \"I give up\" or \"Do what you want because I don't care\". You will get a \n" +
          "raised eyebrow \"Go Ahead\" in just a few minutes, followed by \"Nothing\" and \"Fine\" \n" +
          "and she will talk to you in about \"Five Minutes\" when she cools off.\n" +
          "\n" +
          "6. (Loud Sigh)\n" +
          "\n" +
          "This is not actually a word, but is still often a verbal statement very misunderstood by men. \n" +
          "A \"Loud Sigh\" means she thinks you are an idiot at that moment and wonders why she is wasting \n" +
          "her time standing here and arguing with you over \"Nothing\".\n" +
          "\n" +
          "7. (Soft Sigh)\n" +
          "\n" +
          "Again, not a word, but a verbal statement. \"Soft Sighs\" are one of the few things that some men actually understand. \n" +
          "She is content. Your best bet is to not move or breathe and she will stay content.\n" +
          "\n" +
          "8. \"Oh!\"\n" +
          "\n" +
          "This word followed by any statement is trouble. Example; \"Oh, let me get that\". Or, \n" +
          "\"Oh, I talked to him about what you were doing last night\". If she says \"Oh\" before a statement, \n" +
          "RUN (do not walk) to the nearest exit. She will tell you that she is \"Fine\" when she is done tossing your clothes out the window, \n" +
          "but do not expect her to talk to you for at least 2 days. \n" +
          "\"Oh\" as the lead to a sentence usually signifies that you are caught in a lie. Do not try to lie more to get out of it, \n" +
          "or you will get raised eyebrows, \"Go ahead\", followed by acts so unspeakable that I can't bring myself to write about them.\n" +
          "\n" +
          "9. \"That's Okay\"\n" +
          "\n" +
          "This is one of the most dangerous statements that a woman can say to a man. \"\n" +
          "That's Okay,” means that she wants to think long and hard before paying you retributions for whatever it is that you have done. \n" +
          "\"That's Okay\" is often used with the word \"Fine\" and used in conjunction with a raised eyebrow and \"Go Ahead\". \n" +
          "At some point in the near future when she has plotted and planned, you are going to be in some mighty big trouble.\n" +
          "\n" +
          "10. \"Please Do\"\n" +
          "\n" +
          "This is not a statement it’s an offer. \n" +
          "A woman is giving you the chance to come up with whatever excuse or reason you have for doing \n" +
          "whatever it is that you have done. You have a fair chance to tell the truth, so be careful and you shouldn't get a \"That's Okay\".\n" +
          "\n" +
          "11. \"Thanks\"\n" +
          "\n" +
          "The woman is thanking you. Do not faint; just say, \"you're welcome\".\n" +
          "\n" +
          "12. \"Thanks A Lot!!\"\n" +
          "\n" +
          "This is very different to \"Thanks\". \n" +
          "A woman will say, \"Thanks A Lot!!\" when she has REALLY had enough of you. It signifies that you have hurt her in some callous way, \n" +
          "and will be followed by the \"Loud Sigh\". Be careful not to ask what is wrong after the \"Loud Sigh\", as she will only tell you \"Nothing\"."
        }
    };

    /** The readme */
    private String readmeText =
        "Slackpad 2003 (v1.0)\n" +
        "by Matthew Sital-Singh\n" +
        "\n" +
        "Welcome to Slackpad.\n" +
        "This program is designed specifically for the idle layabout in you\n" +
        "who would rather dream about last night's activities than sit typing\n" +
        "out long documents (in particular Students).\n" +
        "\n" +
        "This program can be used as a simple text editor to enter notes and\n" +
        "suchlike - but if that is what you are into then you are using\n" +
        "the WRONG program. (For this reason, there is no 'Save' facility in\n" +
        "Slackpad and so any work you may decide to do will be rendered useless)\n" +
        "\n" +
        "Slackpad only comes into its own when the 'Slacker mode' is turned on\n" +
        "(Tools -> Slacker Mode)\n" +
        "You may notice that when you try to 'Open' a text file nothing appears\n" +
        "to happen. This is the beauty of Slackpad.\n" +
        "\n" +
        "In 'Slacker' mode, keypresses are not interpreted in the normal way.\n" +
        "Instead of transferring the contents of your typing into the main window, \n" +
        "Slackpad writes out the contents of the Text file which you previously\n" +
        "'Opened' - making it look as if you are typing the whole thing\n" +
        "out in realtime with no work or thought required on your part!\n" +
        "\n" +
        "Try it now!\n";

}
