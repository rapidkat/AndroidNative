#!/usr/bin/perl -w

# Declare the subroutines
sub trim($);

# Perl trim function to remove whitespace from the start and end of the string
sub trim($)
{
	my $string = shift;
	$string =~ s/^\s+//;
	$string =~ s/\s+$//;
	return $string;
}

# (1) quit unless we have the correct number of command-line args
$num_args = $#ARGV + 1;
if ($num_args != 4) {
  print "\n======================= INCORRECT USAGE =======================\n";
  print "\nUsage: input_parsed_json_file version_tag_number type_of_data temp_file\n";
  print "\nperl parse_and_add_to_couch.pl parsedJsonFile.json 101 overall tempFile.json\n";
  print "\ntype_of_data can be one of: overall, androidversion, applicationversion\n";
  exit;
}

# (2) we got two command line args, so assume they are the
# first name and last name
$input_file=$ARGV[0];
$version=$ARGV[1];
$data_type=$ARGV[2];
$output_file=$ARGV[3];

$string_to_prepend="{\"Iteration\": $version, \"dataType\":\"$data_type\", \"dataArray\":";

$string_to_postpend="}";

open (MYFILE, ">>", $output_file);

print MYFILE $string_to_prepend;

open(INFO, $input_file) or die("Could not open file.");

foreach $line (<INFO>)  {
	my $linei = trim($line);
    print MYFILE $linei;    
}
print MYFILE $string_to_postpend;

close(INFO);

close(MYFILE);

# all done now send the data to couch
system "curl -H \"Content-Type:application/json\" --data \@$output_file -vX POST http://127.0.0.1:5984/proto2";
