# PDFMerger
PDFMerger is an application designed to help administrative personnel when scanning PDF files. The application will either 'merge' two separate files (even and odds pages) or 'reorder' a single file (first the odd pages, then the even ones). This terminology of 'merge' and 'reorder' will be continously used.

## Why was this application designed and developped
Most times, in order to minimize how much paper is used, documents will be printed double-sided. However, double-sided scans are quite expensive, making scanning these files time-consuming because someone has to manually reorder the files scanned.

## Why Java 1.8
This application was originally designed for a small spanish law bureau, these lawyers need Java 1.8 to interact with some government web applications. Considering the algorithm uses very basic structures, adapt PDFMerger to this bureau was easier.

## Installation and usage
To use PDFMerger it is only required to have Java 1.8 or latter installed in the PC.
The latest jar file is:
[PDFMerger.jar](out%2Fartifacts%2FPDFMerger_jar%2FPDFMerger.jar).

To open the application, simply open the file, it should show a console like the following:

![main_window_preview.png](pdf-merger%2Fsrc%2Fmain%2Fresources%2FREADME%20images%2Fmain_window_preview.png)

The 'name of the new file' field can be left empty, in which case the new file will be named after the day and time the new file is created.

## Dependencies
This projects makes use of the PDFbox library when dealing with the PDF files.
It's set to version 2.0.30 because latter versions so far corrupt files with images, adding a blank page instead of the one required.