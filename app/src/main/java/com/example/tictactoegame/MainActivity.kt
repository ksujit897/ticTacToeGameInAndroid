package com.example.tictactoegame

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    enum class PLAYINGPLAYER {
        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER_OF_THE_GAME {

        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE
    }

    // instance variable

    var playingplayer: PLAYINGPLAYER? = null
    var winnerOfTheGame: WINNER_OF_THE_GAME? = null

    var player1Options: ArrayList<Int> = ArrayList()
    var allDisabledImages: ArrayList<ImageButton?> = ArrayList()
    var player2Options: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playingplayer = PLAYINGPLAYER.FIRST_PLAYER
//      playingplayer = PLAYINGPLAYER.SECOND_PLAYER

    }


    fun imageButtonTapped(view: View) {
        var selectedImageButton: ImageButton = view as ImageButton

        var randomNumber: Int = ((Math.random() * 9) + 1).toInt()

        when (randomNumber) {
            1 -> tableLayout.setBackgroundColor(Color.GREEN)
            2 -> tableLayout.setBackgroundColor(Color.BLUE)
            3 -> tableLayout.setBackgroundColor(Color.YELLOW)
            4 -> tableLayout.setBackgroundColor(Color.MAGENTA)
            5 -> tableLayout.setBackgroundColor(Color.WHITE)
            6 -> tableLayout.setBackgroundColor(Color.CYAN)
            7 -> tableLayout.setBackgroundColor(Color.RED)
            8 -> tableLayout.setBackgroundColor(Color.LTGRAY)
            9 -> tableLayout.setBackgroundColor(Color.DKGRAY)
        }

        var optionNumber = 0

        when (selectedImageButton.id) {
            R.id.imgButton1 -> optionNumber = 1
            R.id.imgButton2 -> optionNumber = 2
            R.id.imgButton3 -> optionNumber = 3
            R.id.imgButton4 -> optionNumber = 4
            R.id.imgButton5 -> optionNumber = 5
            R.id.imgButton6 -> optionNumber = 6
            R.id.imgButton7 -> optionNumber = 7
            R.id.imgButton8 -> optionNumber = 8
            R.id.imgButton9 -> optionNumber = 9
        }

        action(optionNumber, selectedImageButton)
    }

    private fun action(optionNumber: Int, selectedImageButton: ImageButton) {

        if (playingplayer == PLAYINGPLAYER.FIRST_PLAYER) {
            selectedImageButton.setImageResource(R.drawable.x_letter)
            player1Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingplayer = PLAYINGPLAYER.SECOND_PLAYER


        } else if (playingplayer == PLAYINGPLAYER.SECOND_PLAYER) {
            selectedImageButton.setImageResource(R.drawable.o_letter)
            player2Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingplayer = PLAYINGPLAYER.FIRST_PLAYER
        }

        specifyTheWinnerOfGame()
    }

    private fun specifyTheWinnerOfGame() {
        if (player1Options.contains(1) &&
            player1Options.contains(2) &&
            player1Options.contains(3)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE
        } else if (player2Options.contains(1) &&
            player2Options.contains(2) &&
            player2Options.contains(3)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(4) &&
            player1Options.contains(5) &&
            player1Options.contains(6)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE
        } else if (player2Options.contains(4) &&
            player2Options.contains(5) &&
            player2Options.contains(6)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(7) &&
            player1Options.contains(8) &&
            player1Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(7) &&
            player2Options.contains(8) &&
            player2Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(1) &&
            player1Options.contains(5) &&
            player1Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(1) &&
            player2Options.contains(5) &&
            player2Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(3) &&
            player1Options.contains(5) &&
            player1Options.contains(7)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(3) &&
            player2Options.contains(5) &&
            player2Options.contains(7)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(1) &&
            player1Options.contains(4) &&
            player1Options.contains(7)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(1) &&
            player2Options.contains(4) &&
            player2Options.contains(7)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(2) &&
            player1Options.contains(5) &&
            player1Options.contains(8)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(2) &&
            player2Options.contains(5) &&
            player2Options.contains(8)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        } else if (player1Options.contains(3) &&
            player1Options.contains(6) &&
            player1Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_ONE


        } else if (player2Options.contains(3) &&
            player2Options.contains(6) &&
            player2Options.contains(9)
        ) {
            winnerOfTheGame = WINNER_OF_THE_GAME.PLAYER_TWO
        }

        if (winnerOfTheGame == WINNER_OF_THE_GAME.PLAYER_ONE) {

            createAlert(
                "Player One Wins",
                "Congratulations to Player 1",
                AlertDialog.BUTTON_POSITIVE,
                "OK",
                false
            )

            return

        } else if
            (winnerOfTheGame == WINNER_OF_THE_GAME.PLAYER_TWO){
            createAlert(
                "Player Two  Wins",
                "Congratulations to Player 2",
                AlertDialog.BUTTON_POSITIVE,
                "OK",
                false
            )

            return
        }

        checkDrawState()
    }








    private fun createAlert(
        title: String, message: String, whichButton: Int,
        buttonText: String, cancelable: Boolean
    ) {

        val alertDialog: AlertDialog =
            AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        alertDialog.setButton(whichButton, buttonText, { dialog: DialogInterface?, which: Int ->

            resetGame()

        })

        alertDialog.setCancelable(cancelable)
        alertDialog.show()

    }

    private fun resetGame() {

        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerOfTheGame = WINNER_OF_THE_GAME.NO_ONE

        playingplayer = PLAYINGPLAYER.FIRST_PLAYER


        imgButton1.setImageResource(R.drawable.logo)
        imgButton2.setImageResource(R.drawable.logo)
        imgButton3.setImageResource(R.drawable.logo)
        imgButton4.setImageResource(R.drawable.logo)
        imgButton5.setImageResource(R.drawable.logo)
        imgButton6.setImageResource(R.drawable.logo)
        imgButton7.setImageResource(R.drawable.logo)
        imgButton8.setImageResource(R.drawable.logo)
        imgButton9.setImageResource(R.drawable.logo)

        imgButton1.isEnabled = true
        imgButton2.isEnabled = true
        imgButton3.isEnabled = true
        imgButton4.isEnabled = true
        imgButton5.isEnabled = true
        imgButton6.isEnabled = true
        imgButton7.isEnabled = true
        imgButton8.isEnabled = true
        imgButton9.isEnabled = true

    }

    private fun checkDrawState()
    {

        if (allDisabledImages.size == 9 && winnerOfTheGame != WINNER_OF_THE_GAME.PLAYER_ONE
            && winnerOfTheGame != WINNER_OF_THE_GAME.PLAYER_TWO)
        {
            createAlert("DRAW!!" ,"No one won the game!!" ,
                AlertDialog.BUTTON_POSITIVE,"OK", false)
        }

    }
}

