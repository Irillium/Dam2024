package edu.iesam.dam2024.feature.pokemons.domain

data class Pokemon(
    val id: String,
    val name: String,
    //val baseExperience: String,
    //val height: String,
    //val isDefault: Boolean,
    //val order: String,
    //val weight: String,
    //val abilities: List<Ability>,
    //val forms: List<Form>,
    //val gameIndices: List<GameIndex>,
    //val heldItems: List<HeldItem>,
    //val locationAreaEncounters: String,
    //val moves: List<Move>,
    //val species: Species,
    val sprites: Sprites,
    //val cries: Cries,
    //val stats: List<Stat>,
    //val types: List<Type>,
    //val pastTypes: List<PastType>
)

data class Ability(
    val isHidden: Boolean,
    val slot: Int,
    val ability: AbilityDetail
)

data class AbilityDetail(
    val name: String,
    val url: String
)

data class Form(
    val name: String,
    val url: String
)

data class GameIndex(
    val gameIndex: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)

data class HeldItem(
    val item: Item,
    val versionDetails: List<VersionDetail>
)

data class Item(
    val name: String,
    val url: String
)

data class VersionDetail(
    val rarity: Int,
    val version: Version
)

data class Move(
    val move: MoveDetail,
    val versionGroupDetails: List<VersionGroupDetail>
)

data class MoveDetail(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val versionGroup: Version,
    val moveLearnMethod: MoveLearnMethod
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class Species(
    val name: String,
    val url: String
)

data class Sprites(
    val backDefault: String?,
    //val backFemale: String?,
    //val backShiny: String?,
    //val backShinyFemale: String?,
    //val frontDefault: String?,
    //val frontFemale: String?,
    //val frontShiny: String?,
    //val frontShinyFemale: String?,
    //val other: OtherSprites,
    //val versions: VersionsSprites
)

data class OtherSprites(
    val dreamWorld: DreamWorld,
    val home: Home,
    val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)

data class DreamWorld(
    val frontDefault: String?,
    val frontFemale: String?
)

data class Home(
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?
)

data class OfficialArtwork(
    val frontDefault: String?,
    val frontShiny: String?
)

data class Showdown(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?
)

data class VersionsSprites(
    val generationI: GenerationSprites,
    val generationII: GenerationSprites,
    val generationIII: GenerationSprites,
    val generationIV: GenerationSprites,
    val generationV: GenerationSprites,
    val generationVI: GenerationSprites,
    val generationVII: GenerationSprites,
    val generationVIII: GenerationSprites
)

data class GenerationSprites(
    val redBlue: RedBlue?,
    val yellow: Yellow?
)

data class RedBlue(
    val backDefault: String?,
    val backGray: String?,
    val frontDefault: String?,
    val frontGray: String?
)

data class Yellow(
    val backDefault: String?,
    val backGray: String?,
    val frontDefault: String?,
    val frontGray: String?
)

data class Cries(
    val latest: String,
    val legacy: String
)

data class Stat(
    val baseStat: Int,
    val effort: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String,
    val url: String
)

data class Type(
    val slot: Int,
    val type: TypeDetail
)

data class TypeDetail(
    val name: String,
    val url: String
)

data class PastType(
    val generation: Generation,
    val types: List<Type>
)

data class Generation(
    val name: String,
    val url: String
)
