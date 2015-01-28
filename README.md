### sbt-clean-compile.txt

1. in sd.cb.LogView
    + uncomment `import com.sandinh.rx.Implicits._`
    + comment `import Implicits._`

2. run sbt command
    clean
    compile

### sbt-increment-compile.txt

1. in sd.cb.LogView
    + uncomment `import Implicits._`
    + comment `import com.sandinh.rx.Implicits._`

2. run sbt command
    clean
    compile

3. in sd.cb.LogView
    + adding/ deleting `private` modifier from `def row2Obs`

4. run sbt (increment) `compile` command