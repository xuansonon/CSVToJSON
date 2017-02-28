# CSV to JSON
I work very casual hours - because of this I have to enter in my timesheet at work. I also don't like having to enter data in too many times, so I usually wait until my hours stack up before entering my timesheet. It is because of this, I usually spend hours to enter data into an online form and it's so repetitive. Let's be honest, programmers love to make their life easier - and with the CSV to JSON I'm doing just that.<br />
<br />
This CSV to JSON file takes in a .csv file and essentially converts all that information into JSON format. The output is exported to a file (.txt) format which you then can do however you want with that output. Provided the output isn't formatted to look nice - it's just a minified JSON file.<br />
<br />
## How to use the CSVTOJSON application<br />
You start the application with the following:
```
java CSVTOJSON [CSV Filename] [Exported Filename]
```
## Example usages
```
java CSVTOJSON file.csv exported.txt
```
The above I/O will read the file.csv file, and output that information as JSON format to exported.txt.<br /><br />
## Some issues/notes with CSVTOJSON
- All rows must have equal column length (i.e. 10 columns need to all be filled or atleast the last column to be filled).
