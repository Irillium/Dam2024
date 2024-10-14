package edu.iesam.dam2024.feature.pokemons.domain

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)
// Clase principal del modelo Pokemon
data class Pokemon(
    val id: String,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilitySlot>,
    val forms: List<Form>,
    val game_indices: List<GameIndex>,
    val held_items: List<HeldItem>,
    val location_area_encounters: String,
    val moves: List<MoveSlot>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<StatSlot>,
    val types: List<TypeSlot>,
    val past_types: List<PastType>
)

// Habilidad y su slot
data class AbilitySlot(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: Ability
)

data class Ability(
    val name: String,
    val url: String
)

// Formas del Pokémon
data class Form(
    val name: String,
    val url: String
)

// Índices del juego
data class GameIndex(
    val game_index: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)

// Objetos retenidos por el Pokémon
data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)

data class Item(
    val name: String,
    val url: String
)

data class VersionDetail(
    val rarity: Int,
    val version: Version
)

// Movimientos del Pokémon
data class MoveSlot(
    val move: Move,
    val version_group_details: List<VersionGroupDetail>
)

data class Move(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    val level_learned_at: Int,
    val version_group: VersionGroup,
    val move_learn_method: MoveLearnMethod
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

// Especie del Pokémon
data class Species(
    val name: String,
    val url: String
)

// Sprites o imágenes del Pokémon
data class Sprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    val other: OtherSprites
)

data class OtherSprites(
    val dream_world: DreamWorldSprites,
    val home: HomeSprites,
    val official_artwork: OfficialArtworkSprites,
    val showdown: ShowdownSprites
)

data class DreamWorldSprites(
    val front_default: String?,
    val front_female: String?
)

data class HomeSprites(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class OfficialArtworkSprites(
    val front_default: String?,
    val front_shiny: String?
)

data class ShowdownSprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

// Estadísticas del Pokémon
data class StatSlot(
    val base_stat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)

// Tipos del Pokémon
data class TypeSlot(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

// Tipos pasados del Pokémon (de generaciones anteriores)
data class PastType(
    val generation: Generation,
    val types: List<TypeSlot>
)

data class Generation(
    val name: String,
    val url: String
)
