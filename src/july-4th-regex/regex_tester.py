import re

july_4th_regex = re.compile("July?\s(4[th]?|[Ff]ourth)")

def is_there_a_match(regex, string):
	if regex.search(string) is None:
		print string + " was not matched."
	else:
		print string + " was matched."

is_there_a_match(july_4th_regex, "Jul 4")
is_there_a_match(july_4th_regex, "July 4")
is_there_a_match(july_4th_regex, "Jul 4th")
is_there_a_match(july_4th_regex, "July 4th")
is_there_a_match(july_4th_regex, "July fourth")
is_there_a_match(july_4th_regex, "July Fourth")