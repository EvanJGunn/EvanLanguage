# EvanLanguage
An updated version of my language system (vocabulary storage, and tests), using Java Spring libraries and APIs.
Now using the MVC (Model, View, Controller) architecture as well.

# What is the overall architecture?
There are three parts to my spoken language testing system:
1. The Database
2. EvanLanguage (My Web Server) <------------ This repository store the code for this server
3. EvanLanguageWeb (My react.js website) <---- Code in different repository

# The Database
I currently use MySQL, however due to the nature of Spring JPA/Hibernate,
I could easily change the database implementation in production.
The database has three tables. The main table is called word,
each entry represents a word in a language. A word has a language,
a meaning, a romanization, and a type (noun, verb, etc...)

The 2nd table is called symbols. The symbols table has a one to one relationship
with a word entry, although not every word needs to have a symbols entry.
A symbols table entry represents a word's symbols, a word may have main symbols, which
could be the kanji for a japanese word, and ancillary symbols, which could be the
hiragana reading of kanji. Katakana for a loan word would be considered main symbols,
as they do not have a secondary set of symbols.

The 3rd table is called wordsource. The wordsource table also has a one to one
relationship with a word table entry, and a word entry does not need to have
a wordsource entry. A wordsource table entry represents the source for a word,
this could be the title of the book you found the word in, or a videogame, or
the name of an online dictionary. The source helps when generating tests, which
will be covered later. I may later switch the relationship to many-to-one, allowing
many words to be mapped to one source, so that unnecessary space is not taken up.

# EvanLanguage (Spring Boot Web Server) Stored in this repository
This webserver serves my website, as well as providing API endpoints
for interaction with the database. A user may "/save" a new word, "/delete"
an existing word, use "/words" to get a list of all words, use "/word{language}"
to get a list of all words in a language, and may use "/test" to generate
a test based on several criteria. A demonstration will be provided in a youtube video.

# EvanLanguageWeb (react.js website)
This is the website served by the EvanLanguage web server's "/" mapping. It currently has
UI allowing the user to add a word to the databas via API calls, and can also display
tests generated based on criteria, generated by the web server, and gotten via API calls
to the /test endpoint.

# Demonstration Link (Youtube):
(Video not yet made)
