# fork and change little from lcf
class judger:
    def __init__(self):
        with open("testcases/codegen/judgelist.txt") as f:
            oriList=f.readlines()
        self.judge_list = [judge.replace("\n", "").replace("./", "testcases/codegen/") for judge in oriList]
        
    def getJudge(self,path):
        input_contain = []
        std_contain = []
        with open(path) as f:
            lines=f.readlines()
            input_start = False
            std_start = False
            for i in range(len(lines)):
                if lines[i].find("= output =") > 0:
                    std_start = True
                elif lines[i].find("= input =") > 0:
                    input_start = True
                elif lines[i].find("= end =") > 0:
                    input_start = False
                    std_start = False
                elif input_start:
                    input_contain.append(lines[i].replace('\n',''))
                elif std_start:
                    std_contain.append(lines[i].replace('\n',''))
        return "\n".join(input_contain),"\n".join(std_contain)