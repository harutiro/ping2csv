package model

class BuildList {
    companion object{
        var oneBuilder = mutableListOf<Build>(
            Build("1号館-1階", "10.1.12.0", 23),
            Build("1号館-2階", "10.1.20.0", 23),
            Build("1号館-3階", "10.1.32.0", 23),
            Build("1号館-4階", "10.1.40.0", 23),
            Build("1号館-5階-501", "10.1.52.0", 23),
            Build("1号館-5階-502", "10.1.56.0", 23),
            Build("1号館-6階", "10.1.60.0", 23),
            Build("1号館-7階", "10.1.72.0", 23),
        )

        var fourBuilder = mutableListOf(
            Build("4号館-1階", "10.4.12.0", 23),
            Build("4号館-2階", "10.4.20.0", 23),
            Build("4号館-3階", "10.4.32.0", 23),
            Build("4号館-4階", "10.4.40.0", 23),
        )

        var fourAnotherBuilder = mutableListOf(
            Build("4号館別館-1階", "10.4.112.0", 23),
            Build("4号館別館-2階", "10.4.120.0", 23),
            Build("4号館別館-3階", "10.4.132.0", 23),
            Build("4号館別館-4階", "10.4.140.0", 23),
        )

        var tenBuilder = mutableListOf<Build>(
            Build("10号館-1階", "10.10.12.0", 23),
            Build("10号館-1階-G2110", "10.10.112.0", 23),
            Build("10号館-2階", "10.10.20.0", 23),
            Build("10号館-2階-G2210", "10.10.120.0", 23),
            Build("10号館-3階", "10.10.32.0", 23),
            Build("10号館-4階", "10.10.40.0", 23),
            Build("10号館-5階", "10.10.52.0", 23),
            Build("10号館-6階", "10.10.60.0", 23),
            Build("10号館-7階", "10.10.72.0", 23),
        )

        var aiwa = mutableListOf(
            Build("愛和-1階", "10.17.112.0", 22),
            Build("愛和-2階", "10.17.120.0", 22),
        )

        var central = mutableListOf(
            Build("セントラル", "10.17.32.0", 21),
        )

        var pulaza = mutableListOf(
            Build("プラザ", "10.17.0.0", 21),
        )

        var builds = mutableListOf(
            oneBuilder,
            fourBuilder,
            fourAnotherBuilder,
            tenBuilder,
            aiwa,
            central,
            pulaza,
        )
    }
}