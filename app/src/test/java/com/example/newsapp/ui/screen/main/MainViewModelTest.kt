package com.example.newsapp.ui.screen.main

import androidx.paging.PagingData
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.NewsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import app.cash.turbine.test
import com.example.newsapp.data.model.Source
import kotlinx.coroutines.Dispatchers

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: NewsRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()

        coEvery { repository.getTopHeadlines().flow } returns flowOf(PagingData.empty())
        viewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `selectArticle updates selectedArticle state`() = runTest {
        val article = Article(
            title = "Test Article",
            description = "Description",
            url = "https://example.com",
            urlToImage = null,
            author = "Author",
            publishedAt = "2024-01-01T00:00:00Z",
            source = Source("Some id", "Some source name"),
            content = "Content of the article"
        )

        viewModel.selectArticle(article)

        viewModel.selectedArticle.test {
            assertEquals(article, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `newsFlow emits PagingData from repository`() = runTest {
        viewModel.newsFlow.test {
            val item = awaitItem()
            assertNotNull(item) // Should emit an empty PagingData
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `selectedArticle initial value is null`() = runTest {
        val selected = viewModel.selectedArticle.value
        assertNull(selected)
    }
}
