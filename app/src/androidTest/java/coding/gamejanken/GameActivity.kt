package coding.gamejanken

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListeners() {
        rockImageButton.setOnClickListener { StarGame ("ROCK ")}
        scissorsImageButton.setOnClickListener { StarGame("SCISSORS" )}
        paperImageButton.setOnClickListener{ StarGame("PAPER")}
    }

    private fun StarGame(option: String) {
        val computerOption = game.pickRandomOption()
        computerImageView.setImageResource(game.pickDrawable(computerOption))

        when {
            game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.game)
        
        initComponents()
        initListeners()
    }

}