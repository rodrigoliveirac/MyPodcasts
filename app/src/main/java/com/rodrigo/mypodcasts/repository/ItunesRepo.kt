package com.rodrigo.mypodcasts.repository

import com.rodrigo.mypodcasts.service.ItunesService

class ItunesRepo(private val itunesService: ItunesService) {

    suspend fun searchByTerm(term: String) =
        itunesService.searchPodcastByTerm(term)

}