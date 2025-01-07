package leetcode.L1930;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // time limit exception
    public int countPalindromicSubsequence(String s) {
        int n = s.length() - 1;
        if (n < 3) return 0;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            char left = s.charAt(i);

            for (int j = n; j >= 0; j--) {
                char right = s.charAt(j);
                if (j > i) {
                    if (left == right) {
                        for (int j2 = i + 1; j2 < j; j2++) {
                            set.add(left + s.substring(j2, j2+1)+right);
                        }
                    }
                }
            }

        }

        return set.size();
    }

    //done
    public int countPalindromicSubsequence1(String s) {
        int n = s.length();
        int [] firstPointer = new int [26];
        int [] lastPointer = new int[26];
        int result = 0;

        Arrays.fill(firstPointer, -1);

        for(int i =0; i<n; i++) {
            int current = s.charAt(i) -'a';

            if(firstPointer[current] ==-1) {
                firstPointer[current] = i;
            }
            lastPointer[current] = i;
        }

        Set<Character> set;
        for (int i =0; i< 26; i++) {

            if (firstPointer[i] == -1) {
                continue;
            }
            set = new HashSet<>();

            for (int j = firstPointer[i] +1; j<lastPointer[i]; j++) {
                set.add(s.charAt(j));
            }
            result += set.size();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "tnapzbjeznakaxowyeqefiwxpoxswedvabnyyuihjenxmpzxyyokldoijgvekjxxvxsvcnrinonkofilfyllcacophzuusnbyhpxoqtnbhezbvwtnejsxcyxsbffqaxfryagvvzzvjvbdgrwkowqfwthrkkhxvmpqkslrfqcxmeiygryknhocdvwyomdzmcfvetugpldpbytefioyiyxjfqkdhbefrlwbgnodzbrknqeyjdcgjovtdfqobqxyqhqltrpizlxdnjdqezzwjaudlsofkvjykktlkjiksffefwrqxotkqfdcqhvuqbfoejnelskrhtoekufkmwdyiyptwrucawbwixfdfvjxpvmshcoxdknqeomzrxzrdltdjjearvypexzyoxzxbdhkdzurzisycpuaxkewehnxmxbghllbttlcodzqtajxjarsiuwukiysomgxxcrincvucbjeuuwaauwqeqwlwucdsftccyaugbcinmfzpehrwbeaefdozssbeizeqppnhlvtnrzgtbbitqvctsatcpxjrrbgvltmmtizepbjmmywzmxldtkadizqkaurepeckdiakhyofmslyezbybimhgyukaieqrlddhsuwjzblkfigwixzuopifdiqzfpgvmmanctqcmpxygluuhdwbgqivmdhizpnvqypdttfuhukvagdaqtcmxdqoptchhsledydwojisoqqkivahoowbsdbbdnygtziktmonqkevvlcxggqobvfbfgdwnitratmrsobpfpaspjxefnxthonefpiigdhapqnkebutwfotvrxvjbqowgnifeimsslktxmpuryccaabahalsycjqztjhqhaddlyzxdqyuwyecslxshaobrfkjalmeaxrywssfgrzervzbowosusthcjvojxsoiqkpjztdrxrkycgdyqlorxixzdiqtwozuvkvwzonogoytrumivjynvfjktcqlvxeauncdbygkvocvaadeubgykjkshkflpmpbmaiaswjocrqjzmabmxmocssxltgzaiuwfkadwuylnmskyqbpsmxhehicevfmauuxubeirvflsxcdtyoljsansqcmhokbgyjkxxwdeorlzjgbuekogddsabucrpawdxwuemmckqouddnwbnzogtvjfgblwuarykpwtdpuxqtephulabcxdqjkmuxhniiynkwrsypromcminqgghhnixxojhvnkglrtxduhrjoiupeswqfuveqmgmhondpgzvzaeyylzphofblzpmkdejubwhoguyrfxoaiqhlfqogovdoifuvfqyctzhmcvfleefcgippkfccsltjpjohwmunimqvpjspsjufikghgpmaygslukijmsxcgfjzmewqpvvzjtcxcsbcylhwhxfingcbruyyeoyxgvfsbcvedmtsdygawtnanbdbedwvohgecgqtbjalurkoknzyjpsttnknmufpjhpkjjifalqdwutqhgaflmmmwmkbyxxhbmkqlpjnmywmjfxezdshafnakulqhbndlmtausobzyjrlsgdxcjkbhyfokvdogxabwgmbmzymclxqzwygoxvirnrvpruugvlhyhzzbpugvovfymdcojtkicemybixlvemaydgwmypkwhpeeijccuaomczvqzaedzjrvjobxibpzpveekzcpqnvhbpgqscprawrsvjnhskugziigdecpdcldburpsldqyopyfmaeebawgemrksidizkixosauykmzdwgpyxskuqsujamvnfirtnnxzpplyulsootbikqumwyxpgiplhqbfxggnbylklyuhvoknyuqhpbzfrhdgzoiofrcqyadtgrrkxfecyioobzwwaguuyzcldtumdrhcujkeysxqztzeinrfztjiktcnvfequtbzfrxmukqfblajzyqkvzwcvpoddmzsiqaviivhwbhzdgjdikbnbihaziswypwjcgixefughvoowvoprhohxtbxkrgbbypcmmjogpouceqowqafseywnzanhuueobfrfnikpxhgwdkqmzkegdeqdrdbzttrdfyoqsvacfdsuwikrrlfqfjwwrmylgleuvtnfchhetmtblhffwvzhmlduqjzoqdgjgcwnikbycxggyywoyxqzayirooafchtgupqryojjqxiwjtnmlorcxgwfkzbrzldtfcgxkzqxxcypcgptygmhetsymzuxcnfoasytoetzorfvgbevfhblqassjttvlrvejeaevkcebklsesswnxpzpilvprflevlipyuvfhumcpudbtnwokqsvbewugbwobocncgovbmvduscdlkqctlrziaaaravaitvpceycuojutpszirunhheodrohntdvhqbjblapaggiijnnkogdhfirjvujbsqbfkwoquaqqyyebgbdkvdonaqgweymynjtnbgebsqheorskegksjsnfiucwvhzkjttwbkfrirhyxacjkhhovnxutjonezizmvbrarbwgxftjvgiskfdccpnsuopfpqffkifwwsyxpntikmnkowxaevzacucdpygjmsghzdskaqfjudbibdnuhofkmvptkesypnblikcyswhnktvquimklubsdduabfznfkwcwaelitcefxjvneomwloxqzvhzdhouzuigwxtnkfqpdcjravnzpbhoyslgukpoykqvwrvqttrtwcndupqodohuxouwyxcvufuuloybqaoeqlkxqefozfpirxqxnroavhaikrzxolauuktodrcooiqyfovcvwtuiiydvukdpuwhxwvetarnpxkzdzkfcfpvvayjbqcqbtbkeqfplkdsfhamlhesldkwrpiocwsvxyzoybuayrgzflcdyjyfxkmymfzxrcejfkvzimozjelxohpsepbwhbvlhblrvknyxtmnxbvqwxpvcfnzeotmtpglvwowweriaftyaupslrzlskygkudujaocveqiezrraizyrkdbqyboiklpbpuglphoaexaiapsrozprnhdwitnqqhlolvxsljexkkftraqhuzbqzmnjdqxnseviomtunraqrujswrwtksilarexetwgenlkdvpegyrtwuvfyoxockgrxetsyeykzeyfsiprcwycsjaqnyyoaimrvffqdrnpycmmbnspgavfhiliicsjxvmvnglwbygwsqcyuajlqydpmbtdmhdvnwjedivvlbiunullhemiitroipzuispedyxzvlidwwbujfqgydwwvuwbaiafqoechwnjpzmmwzflqlyqdajntejfynueovtebfdvahcjacggesmaemncluxmitjqmjwyiqnurlxoskoeldmbrfusyrzyyieooptwyturpqgogeqsgpxfoikmqtwfvhyoggvupselvwleebbgxmnmcmxipoxgdvtcukuwoewgopyxnnojftsjneqkbvtztfhhxqvwocbvefsxwadpuspjahmqtfpfakmfpczdbddfdrslmrbptcckdedslsrytyfqsaolinrlwvucthchurqdiarzdhdvpsjzsvbtrufrpdsmaczdhljijhyfayxuazykjegmbpbszlwafdhqxigwvrqfshgdqxkmxqjxiblrzjlegmcvglcotunbaxuocktcenonvrldaszsmfblgmfcbwjnhhuesaoennjllgadafrwfkvxlglkvcpnvsmazkliiptubprdgarpoybstwqhagzbubpnvhvvykpzqqfprvjohkjcfhbmggeietzrppxzlasxelzramnvoecberauqcyyyugrtopxuldczztnqzynvwzyxhdtlwjnyolnlaevgbmmcvvjcpcqcexrpuplxdskyrwrbbjsguuljbxqehxroijcypwrqeqxyshpjggpalibaocdzjtvkodnoufnnnpwdgmztlolqbhfvptsjtpvzwscfsxizbgocivaexhhddciafhaokbtmxtudgntqoyswmocchnzuvqxqyoqnugzkqlyjixcigircpsrbrmjsjsjbcrbvnuufiksdngjbmbpqhdnpehjjwutolmbugauiljtixouiifuuadwjuwuweksbkipfbsreeehzulwsmktpkcescjznynnkbtzamnkszdwepyluaulzkgevbsxbnftmfipktbozqjgnidotnwjtybrlhjqidfwcyesluptzrqvclutghqtmawojebmsrbwpkgbiqapufsndqfwwawwutnskmhxviegxyglvfnjbpfsoarturgpdlnrwtuolpnexrbzipdmhldjacsptjggxvqpegoczzrmkvyoznnbpyedvafxarklcxnqroumkachjuhxgoyqqcnbmktwqfiwpvuafuavkejvyyplbarlzrkcaqxhccvzfhvocpxpumnautlohdnoqepunoonqdnrqubauljvoxapdydwtjwqpveazoayxjdbliiyllsrdhpucrvohppyledyiplvwxgtgdvjhmviudvdvjvsatbkyxkylfdwmeeoisuacnyversgdkkyyujmbjosycozpvxcvcecwtfvubofabliaygszcnuoihvdompowkdgytktyundmuvcxsbgbjopfemhzuslnwgwdnkhoblfozzxynozifxuqwkdbillhbjqjjkfevpoitcmssrpxcccuyczaihyrbseasjgvysceacdliuowbekvxccfsewzrrgqqahymtsvmoyspjaftbakyqzuarpajywlnstboqxyzipxyjtgjodjbbzopqklxvbosmbsgmgrsyrohpzjfamjweifqvbfjgxecnebeysduiwbtabxkrjatoxngdxckfdyhryyltzozlwwcpplebygrwuxdjncmmapalciesoelycusejxunxsrolunfjocpitrmscobbzignvpfojynpxuhyibcnetebopnqvfreghmhfdtnckyjpfadqaafbysfdsmwdwgsbudcibgfrviugvljxcndbaepkwrtmjpwetndugvtvbkeoufdmnjojvvxltxjsycnkjhhtgrllzrpefkaqjldedwdhdfkdvirsgdrwqynmzyqtydgivcprgfigdzzyzejbnfgfvvgcvwnkjsjmsxogilpxuguxqyjgjmwkypnzbfhcijnxoyyxhcitpiyokvewglzdjszgkyhzyqpgxyvhiisbofufyranrdyvxddjocyhejzhxlxugvqrbmqeqvanuwvfllpkiemcxqbtsvvybyjqrbadwediirydahzrdxtnqczxffqjeuespeswuiszjxrfgequlsenpajmsxvufflnzmcbzbepudnewjcmecqyzfzrqecwrvlsgwumitdfzfrdyxnqthzizwosrrweykjvqzfrxgxumubqnhrmcgmiwyuqiarfkkburfvmjbsubiouyrjlsboxilaycspfiojemadgleaqqcschyotlyknqkonfemmcpudqraysznmojvyyrxsiccuieyruqedbdbvumjzolxmsakokirlkopyxcvkjrawakjsmatzoqzlcqqdsffspsejeekfhzwpxqooikxklhigxythgbxpkyptgswhlfwwgnrrodbikpmyzrnunwhgcaxodrcmbixnfqujmpwdgbhlhydpovdtjdctlwwnpepqvzoluxpygjhgikcfojxheverdwflekraglpnsukvvauzqsxohtyducrmxbgzhvbfuvyevphketsttfdzqgddkzfwffgmbrrllyawdmptixbhjbyegpuveahxubolyuvuxaleeuhwbvsxgwmucxqrigcupwybjonxerqiwbepuprkthgntymqlubedcbnzbszoutbxzbwwmsuypjpqgjptxccexytgoeawdcerrgwjyxtaofzhlxannnpihaewpjnjpwermqxkqfypigexmuejdkxjcvdroydhbyytfditsklmsekvsrybjignqocfcrtbhnwsevcwcvujhrwsnwonzhatciobihdvaueyxmqmvnuyqhwtudldhepsldbehbhpnuctyxowwcwlvkpzhrcescobwkareaaytofkwaqiegngsyoekveutblnlvtyweoxwnxrwfvktnqwzxttelgozczeruffpconzjetsbmstyaymkqkqjpaxncrguqmlklnczkwqohrerzvdkjykjewocifqpxeiprqalhdwagmtkpzblqmoophrgjqokbnuuwcmhlyikpvcjungiuequwievzedlkhpbvengnuawoerbmrogpmvtcjzgdyuxbfrstkpwpqazjhotelovzlonmsadmkqactlxdgxhzdpbmryoyvjhbdudxplmileyepifqrlammkorippicvgfavzhsfevxbtkryybsmyqqmeunogjiroephrjsikzijcbibwbiclhmtqjdlnttculjhuofhxfimnfdfcurgqxzlamnexbummavlibelhirysmuncoclmhwmtljevpbifkpoxqlzipourcnompngysesoknxehhyuhtxrsplowvxisjnytvbdlptpxvvvhoqxlcaiphzyvuufmwnkncsqfntwccgzmohxoxaurwvovvlpjdwypfucvinttmttrfratdgpaynwzhqidsbbnvuwsbiwhsfbisumjkxcrnpofgqsqozzvljylgqwvgmejwchkrbdngmlwoktjaxhnjgbskaczmyqfnvxkgzzarodzadkkyncqrlnppuyoobmgtxwqraenthplhiycsvtnxdmlxazuyzutvvutahfnnbmoltzfgktlvcspqcyfvwzeddgebgrewxpsjmatbbrrvhoejuvqbmqcqdtomptmtzwofecmhdhgxqfkcvbfjlrfmdkseydapugxkdofypampacgiuzalpctalecojbnwrmeavixutuzcevzmaggbzvthuxedqaifptdtysphvumeqfeqjcxmcmvsazdyvjocacocynxcuokthpnkmlwzrdmzxnhlatlrzzcahwdlbkttytyfpsdfifonhybefzkhesabetmydaxaffbanghskgcanouzdduaywjtqvdmytpnustqkothzyywomggbxvznrgdcvyccwirojgntzizegwajigkaiypgpswldbbdwsvsocnxqnptzdxdnnbgidfxqfiyfzahecuyoioryquziarxcameblaconlastezdtyljdrgnjmltfvxxtiszhedlzwhvaqiamtqftmdgokmkeyttdlykznwskjskddzyqlzwlwhqmvrpqjazcnnmhdgwvhhktjdcculgtjjoezrhhvtcsmfonmargfrunwusnhunzkwawvzeewirhuewdkitnaymcswkzfbsclvqxbchyfxmdcrtpmqkucqkytyrqtbncqvqvijadflfnsaxorvnadmtsmycarcqzexrwpzgmdfiflkwxauorsjjwnaqrhudwzevkazptowgraurjlrgwxjtwditvxvkayfjzyqtxewssqwphwnfaxtpvvifdjbmjuokhsgrywgocivwhmgzmvplyigitxcoblmudptmcjewqtvmfjdultzukmdjlafvmjutmztmsfmhfaelvvnileboiuknzxenhbkgaqjfmbvfiszkkdpfnsvpkragxnkresuugjanvumptyiwlgaeriltnwmiglcsavndefkvlfbeydctvvqmpzceuewjhvkoaeclpfweaekyooczgrgvbowlwtxucyluxryhfevexjfcvehlzxafottibwqpzisfpdszmocxdkjbzoldlkkiewohzpgtpasnohatztwabascyvpeuxuywgagoafxjffaejbvxuizcxfiisxfknoosffufewkelanjtnqdvutcwbutkxppydgmfmijexjpwqoxizcdkbfmgkywhirnxgcxsxlltaoetngwhesbrwjihsdpcgvnlxldmzjtwdcosguiyuptzhomlqvffgepojjqbisryhwinutnvoziluduankdpehfuwtcpeeejtnjuyktzloetwqcyughhopuprkvldkgvivzjfbvqagbtcfjfqdhmcpjabzydmakkytvbzwkfnyaofehcvrwrfwfkayqhcldfcjxhxfemxnmkxawfghqbhlbiinlzvmqehewhfhucmfiuunkgozewujfvdobrentgqzainixmyekhipaupfnglhwqthlynhlkjolqwwgkmrkgovzbrwcjnpablyevanisqvkhgkwaxfgglnfkqraksxdyeekwxqupulqlftrvbmfkhv";
        Solution solution = new Solution();
        System.out.println(solution.countPalindromicSubsequence(s));
    }
}
// bbcbaba
//     ^ ^