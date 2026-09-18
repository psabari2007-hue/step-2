static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
    // Multiply the captain's score by 2
    playerScores[captainIndex] *= 2.0;
    
    // Multiply the vice-captain's score by 1.5
    playerScores[viceCaptainIndex] *= 1.5;
}