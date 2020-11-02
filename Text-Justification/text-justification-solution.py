class Solution:
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        line = []
        lines = [] 
        length_used = 0
        
        for word in words:
            # 
            if length_used + len(word) <= maxWidth:
                line.append(word)
                length_used += len(word)+1
            else:
                lines.append(line)
                line = [word]
                length_used = len(word)+1
                
                 # The last line is loaded into the lines        
        lines.append(line)    
        
        for line in lines[:-1]:
            l = sum(len(word) for word in line)
            if len(line)==1:
                line[0] = line[0] + ' '*(maxWidth-l)
                        
            else:    
                while l != maxWidth:
                    for i in range(len(line)-1):
                        line[i] = line[i] + ' '
                        l += 1
                        if l == maxWidth:
                            break           
        s = ' '.join(lines[-1])
        if len(s) < maxWidth:
            s = s + " "*(maxWidth-len(s))
            
        return [''.join(line) for line in lines[:-1]] + [s]
        