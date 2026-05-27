package org.arithme.exo.file.hash;

import org.arithme.exo.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
