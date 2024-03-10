import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                char[] geneArray = currentGene.toCharArray();

                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];

                    for (char c : genes) {
                        geneArray[j] = c;
                        String newGene = new String(geneArray);

                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }

                    geneArray[j] = originalChar;
                }
            }

            mutations++;
        }

        return -1;
    }
}
