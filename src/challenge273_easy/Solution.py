import re, math

def radians_to_degrees(radians):
	return radians * (180/math.pi)

def degrees_to_radians(degrees):
	return degrees * (math.pi/180)

valueRegex = re.compile("[0-9]+.?[0-9]+")
unitRegex = re.compile("[a-z]{2}$")


with open("../../input-files/challenge273/inputFile.txt", "r") as inputFile:
	for line in inputFile:
		valueMatch = valueRegex.search(line)
		value_to_convert = valueMatch.group()

		unitMatch = unitRegex.search(line)
		units_list = list(unitMatch.group())

		if units_list[0] == "d" and units_list[1] == "r":
			print str(degrees_to_radians(float(value_to_convert))) + "r"
		elif units_list[0] == "r" and units_list[1] == "d":
			print str(radians_to_degrees(float(value_to_convert))) + "d"
		else:
			print "Invalid input entered."

