fun add(input: String): Int {
    return if(input == "") 0
    else {
        val numbersList = splitNumbers(input)
        if (numbersList.any {it < 0})
            throw Exception("Negative numbers: " + numbersList.filter { it < 0 }.joinToString(","))
        numbersList.filter { it <= 1000 }.sum()
    }
}

private fun splitNumbers(input: String): List<Int> =
        when {
            input.startsWith("//") -> {
                val delimRegex = """//(.*)\n(.*)""".toRegex()
                val delimiters = delimRegex.matchEntire(input)?.groups?.get(1)?.value
                val restInput = delimRegex.matchEntire(input)?.groups?.get(2)?.value
                if (delimiters != null && restInput != null)
                    restInput.split(createRegexForSplit(delimiters)).map { it.toInt() }
                else throw Exception("Moo")
            }
            else ->
                input.split("[,\n]".toRegex()).map { it.toInt() }
        }

private fun createRegexForSplit(delimiters: String): Regex {
    val delimiterList = delimiters.trimStart('[').trimEnd(']').split("][")
    return delimiterList.joinToString("|") { Regex.escape(it) }.toRegex()
}
