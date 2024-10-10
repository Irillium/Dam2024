package edu.iesam.dam2024.feature.movies.domain

import edu.iesam.dam2024.feature.movies.data.MovieDataRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.mockito.kotlin.*

class GetMoviesUseCaseTest {
    val mockService = mock<MovieDataRepository>
    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }
}