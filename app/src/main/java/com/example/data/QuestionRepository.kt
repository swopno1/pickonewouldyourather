package com.example.data

import com.example.model.ChoiceItem
import com.example.model.Question
import com.example.model.QuestionCategory

object QuestionRepository {
    val sampleQuestions: List<Question> = listOf(
        // FUNNY
        Question(
            id = "q1",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Always have to narrate your life out loud like an audiobook narrator",
                textBn = "সারাক্ষণ নিজের সব কাজ অডিওবুকের মতো জোরে জোরে বর্ণনা করতে হবে",
                iconEmoji = "🎙️",
                initialVotes = 1420
            ),
            optionB = ChoiceItem(
                textEn = "Have upbeat disco background music play wherever you walk",
                textBn = "যেখানেই হাঁটবেন পেছনে সবসময় উচ্চশব্দে ডিস্কো গান বাজবে",
                iconEmoji = "🕺",
                initialVotes = 2380
            )
        ),
        Question(
            id = "q2",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Sneeze glitter every single time you sneeze",
                textBn = "প্রতিবার হাঁচি দিলে নাক দিয়ে রঙিন চমকদার গ্লিটার বের হবে",
                iconEmoji = "✨",
                initialVotes = 3120
            ),
            optionB = ChoiceItem(
                textEn = "Hiccup bubble bath bubbles whenever you laugh",
                textBn = "প্রতিবার হাসলে মুখ দিয়ে সাবানের রঙিন বুদ্বুদ বের হবে",
                iconEmoji = "🫧",
                initialVotes = 2740
            )
        ),
        Question(
            id = "q3",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Only be able to walk in slow motion for an entire week",
                textBn = "পুরো এক সপ্তাহ শুধুমাত্র স্লো-মোশনে হাঁটতে পারবেন",
                iconEmoji = "🦥",
                initialVotes = 1890
            ),
            optionB = ChoiceItem(
                textEn = "Have to bow dramatically to everyone you greet",
                textBn = "দেখা হওয়া প্রত্যেক মানুষের সামনে নাটুকে কায়দায় মাথা নত করে কুর্নিশ করতে হবে",
                iconEmoji = "🎩",
                initialVotes = 2050
            )
        ),
        Question(
            id = "q4",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Accidentally send your last photo to your boss / teacher",
                textBn = "ভুলবশত আপনার গ্যালারির শেষ ছবিটি শিক্ষক বা বসের কাছে পাঠিয়ে দেওয়া",
                iconEmoji = "😱",
                initialVotes = 890
            ),
            optionB = ChoiceItem(
                textEn = "Have your internet browser history read aloud at family dinner",
                textBn = "পারিবারিক রাতের খাবারে সবার সামনে আপনার ব্রাউজার হিস্ট্রি জোরে পড়া হবে",
                iconEmoji = "🫣",
                initialVotes = 3910
            )
        ),
        Question(
            id = "q5",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Wear clown shoes on every first date or job interview",
                textBn = "প্রতিটি ইন্টারভিউ বা ডেটে জোকারের বড় রঙিন জুতো পরে যেতে হবে",
                iconEmoji = "🤡",
                initialVotes = 1530
            ),
            optionB = ChoiceItem(
                textEn = "Wear a superhero cape to every formal event forever",
                textBn = "যেকোনো সামাজিক বা আনুষ্ঠানিক অনুষ্ঠানে সুপারহিরোর লাল কেপ পরে থাকতে হবে",
                iconEmoji = "🦸",
                initialVotes = 3280
            )
        ),

        // FOOD
        Question(
            id = "q6",
            category = QuestionCategory.FOOD,
            optionA = ChoiceItem(
                textEn = "Unlimited free gourmet pizza whenever you want for life",
                textBn = "আজীবন যেকোনো সময়ে যত খুশি ফ্রি সুস্বাদু পিৎজা খাওয়ার সুযোগ",
                iconEmoji = "🍕",
                initialVotes = 3840
            ),
            optionB = ChoiceItem(
                textEn = "Unlimited free fragrant biryani / pasta feast forever",
                textBn = "আজীবন যত ইচ্ছে কাচ্চি বিরিয়ানি বা লোভনীয় পাস্তা বিনামূল্যে উপভোগ",
                iconEmoji = "🍲",
                initialVotes = 4120
            )
        ),
        Question(
            id = "q7",
            category = QuestionCategory.FOOD,
            optionA = ChoiceItem(
                textEn = "Give up sweet desserts, chocolates, and sugar forever",
                textBn = "আজীবনের জন্য মিষ্টি, চকোলেট ও ডেজার্ট খাওয়া পুরোপুরি ছেড়ে দেওয়া",
                iconEmoji = "🍫",
                initialVotes = 1920
            ),
            optionB = ChoiceItem(
                textEn = "Give up spicy, crispy, and savory snacks forever",
                textBn = "আজীবনের জন্য ঝাল, মচমচে ও সুস্বাদু নাস্তা খাওয়া পুরোপুরি ছেড়ে দেওয়া",
                iconEmoji = "🌶️",
                initialVotes = 2580
            )
        ),
        Question(
            id = "q8",
            category = QuestionCategory.FOOD,
            optionA = ChoiceItem(
                textEn = "Only drink iced tea / chai for the rest of your life",
                textBn = "সারা জীবন পানীয় হিসেবে শুধু চা বা আইস টি পান করা",
                iconEmoji = "☕",
                initialVotes = 2860
            ),
            optionB = ChoiceItem(
                textEn = "Only drink artisan coffee / fruit smoothies forever",
                textBn = "সারা জীবন পানীয় হিসেবে শুধু ফ্রেশ কফি অথবা স্মুদি পান করা",
                iconEmoji = "🥤",
                initialVotes = 2410
            )
        ),
        Question(
            id = "q9",
            category = QuestionCategory.FOOD,
            optionA = ChoiceItem(
                textEn = "Every meal you cook turns into a 5-star restaurant dish instantly",
                textBn = "আপনি রান্না করলেই তা জাদুর মতো ফাইভ-স্টার রেস্তোরাঁর রাজকীয় খাবার হয়ে যাবে",
                iconEmoji = "👨‍🍳",
                initialVotes = 4590
            ),
            optionB = ChoiceItem(
                textEn = "Never gain weight regardless of what delicious food you eat",
                textBn = "যত ইচ্ছে যা খুশি খেলেও শরীরে এক ফোঁটাও বাড়তি মেদ জমবে না",
                iconEmoji = "🍰",
                initialVotes = 4820
            )
        ),

        // SUPERPOWERS
        Question(
            id = "q10",
            category = QuestionCategory.SUPERPOWERS,
            optionA = ChoiceItem(
                textEn = "Fly freely at 60 mph above cities and oceans",
                textBn = "ঘণ্টায় ৬০ মাইল গতিতে আকাশ ও সাগরের ওপর ইচ্ছেমতো উড়ে বেড়ানো",
                iconEmoji = "🕊️",
                initialVotes = 3980
            ),
            optionB = ChoiceItem(
                textEn = "Teleport instantly to any place in the world with a snap",
                textBn = "তুড়ি বাজিয়ে চোখের পলকে বিশ্বের যেকোনো দেশে বা জায়গায় পৌঁছে যাওয়া",
                iconEmoji = "⚡",
                initialVotes = 5410
            )
        ),
        Question(
            id = "q11",
            category = QuestionCategory.SUPERPOWERS,
            optionA = ChoiceItem(
                textEn = "Read people's minds whenever they are thinking about you",
                textBn = "আপনার সম্পর্কে কেউ কিছু ভাবলেই তা সরাসরি মনে মনে পড়ে ফেলা",
                iconEmoji = "🧠",
                initialVotes = 3210
            ),
            optionB = ChoiceItem(
                textEn = "Be completely invisible whenever you hold your breath",
                textBn = "দম আটকে রাখলেই পুরোপুরি অদৃশ্য হয়ে যাওয়ার ক্ষমতা",
                iconEmoji = "👻",
                initialVotes = 3670
            )
        ),
        Question(
            id = "q12",
            category = QuestionCategory.SUPERPOWERS,
            optionA = ChoiceItem(
                textEn = "Pause time for 10 minutes once every day",
                textBn = "প্রতিদিন ১০ মিনিটের জন্য পুরো পৃথিবীর সময় থামিয়ে দেওয়া",
                iconEmoji = "⏸️",
                initialVotes = 5120
            ),
            optionB = ChoiceItem(
                textEn = "Rewind time by 5 minutes three times every day",
                textBn = "প্রতিদিন ৩ বার করে ৫ মিনিট পেছনে গিয়ে যেকোনো ভুল শুধরে নেওয়া",
                iconEmoji = "⏪",
                initialVotes = 4780
            )
        ),
        Question(
            id = "q13",
            category = QuestionCategory.SUPERPOWERS,
            optionA = ChoiceItem(
                textEn = "Fluent in every human language in the world effortlessly",
                textBn = "বিশ্বের সব মানুষের ভাষা কোনো চেষ্টা ছাড়াই অনর্গল বলতে ও বুঝতে পারা",
                iconEmoji = "🗣️",
                initialVotes = 4620
            ),
            optionB = ChoiceItem(
                textEn = "Talk to animals and perfectly understand their thoughts",
                textBn = "সকল পশুপাখির সাথে কথা বলা এবং তাদের মনের অনুভূতি জানা",
                iconEmoji = "🦜",
                initialVotes = 3890
            )
        ),

        // DAILY LIFE
        Question(
            id = "q14",
            category = QuestionCategory.DAILY_LIFE,
            optionA = ChoiceItem(
                textEn = "Wake up fully energized with just 4 hours of sleep every night",
                textBn = "মাত্র ৪ ঘণ্টা ঘুমিয়েও প্রতিদিন সকালে পূর্ণ সতেজ ও প্রাণবন্ত থাকা",
                iconEmoji = "⚡",
                initialVotes = 4720
            ),
            optionB = ChoiceItem(
                textEn = "Never feel tired, stressed, or burnt out from work or study",
                textBn = "পড়াশোনা বা কাজের চাপে কখনো মানসিক ক্লান্তি বা অবসাদ না আসা",
                iconEmoji = "🧘",
                initialVotes = 4130
            )
        ),
        Question(
            id = "q15",
            category = QuestionCategory.DAILY_LIFE,
            optionA = ChoiceItem(
                textEn = "Your phone battery never drops below 100% ever again",
                textBn = "স্মার্টফোনের চার্জ সারা জীবনে আর কখনো ১০০% থেকে কমবে না",
                iconEmoji = "🔋",
                initialVotes = 3590
            ),
            optionB = ChoiceItem(
                textEn = "Super-fast 10 Gbps internet everywhere on Earth for free",
                textBn = "পৃথিবীর যেকোনো দুর্গম কোণেও আজীবন সুপার-ফাস্ট ১০ জিবিপিএস ফ্রি ইন্টারনেট",
                iconEmoji = "📶",
                initialVotes = 4890
            )
        ),
        Question(
            id = "q16",
            category = QuestionCategory.DAILY_LIFE,
            optionA = ChoiceItem(
                textEn = "Always find the best parking spot / empty seat on public transit",
                textBn = "গাড়ি পার্কিং কিংবা বাস ও ট্রেনে উঠলেই সবসময় সেরা খালি আসন পেয়ে যাওয়া",
                iconEmoji = "💺",
                initialVotes = 2310
            ),
            optionB = ChoiceItem(
                textEn = "Never hit a red traffic light or traffic jam ever again",
                textBn = "রাস্তায় চলার সময় জীবনে আর কখনো লাল বাতি বা যানজটের মুখে না পড়া",
                iconEmoji = "🚦",
                initialVotes = 4910
            )
        ),

        // IMPOSSIBLE CHOICES
        Question(
            id = "q17",
            category = QuestionCategory.IMPOSSIBLE,
            optionA = ChoiceItem(
                textEn = "Travel 100 years into the future with a ticket back",
                textBn = "১০০ বছর ভবিষ্যতের পৃথিবীতে গিয়ে দেখে আসা এবং নিরাপদে ফিরে আসা",
                iconEmoji = "🚀",
                initialVotes = 4320
            ),
            optionB = ChoiceItem(
                textEn = "Travel 100 years into the past with full modern knowledge",
                textBn = "১০০ বছর আগের অতীতে গিয়ে বর্তমান জ্ঞানের সাহায্যে বিশ্বকে বদলে দেওয়া",
                iconEmoji = "⏳",
                initialVotes = 3490
            )
        ),
        Question(
            id = "q18",
            category = QuestionCategory.IMPOSSIBLE,
            optionA = ChoiceItem(
                textEn = "Know the exact date and cause of everything that happens",
                textBn = "ভবিষ্যতে কী ঘটবে তার সঠিক তারিখ ও বিবরণ আগে থেকেই জেনে ফেলা",
                iconEmoji = "🔮",
                initialVotes = 1940
            ),
            optionB = ChoiceItem(
                textEn = "Live with blissful surprises and absolute freedom of choice",
                textBn = "ভবিষ্যতের অনিশ্চয়তাকে সাদরে গ্রহণ করে প্রতিটি মুহূর্ত রোমাঞ্চ নিয়ে উপভোগ করা",
                iconEmoji = "🎁",
                initialVotes = 4810
            )
        ),
        Question(
            id = "q19",
            category = QuestionCategory.IMPOSSIBLE,
            optionA = ChoiceItem(
                textEn = "Win $10,000,000 but you can never leave your home country",
                textBn = "১ কোটি ডলার জয়ী হওয়া, তবে নিজের দেশের বাইরে আর কোথাও যেতে না পারা",
                iconEmoji = "💰",
                initialVotes = 3380
            ),
            optionB = ChoiceItem(
                textEn = "Travel anywhere in luxury for free forever, but earn modest pay",
                textBn = "আজীবন বিশ্বের যেকোনো দেশে বিলাসবহুল ভ্রমণ ফ্রি, তবে সাধারণ উপার্জন",
                iconEmoji = "🌍",
                initialVotes = 4210
            )
        ),

        // TRAVEL
        Question(
            id = "q20",
            category = QuestionCategory.TRAVEL,
            optionA = ChoiceItem(
                textEn = "Live in a luxury beachfront villa with sunset ocean views",
                textBn = "সমুদ্রের পাড়ে সূর্যাস্ত দেখার অপূর্ব বিলাসবহুল ভিলাতে বাস করা",
                iconEmoji = "🏖️",
                initialVotes = 3790
            ),
            optionB = ChoiceItem(
                textEn = "Live in a cozy modern alpine cabin surrounded by snowy mountains",
                textBn = "বরফাচ্ছন্ন পাহাড়ের মাঝে আগুন জ্বালানো আরামদায়ক কাঠের কেবিনে থাকা",
                iconEmoji = "🏔️",
                initialVotes = 3120
            )
        ),
        Question(
            id = "q21",
            category = QuestionCategory.TRAVEL,
            optionA = ChoiceItem(
                textEn = "Spend a month in an underwater glass hotel observing sea life",
                textBn = "এক মাস গভীর সমুদ্রের নিচের কাচের হোটেলে সামুদ্রিক জীবের সাথে থাকা",
                iconEmoji = "🐠",
                initialVotes = 3290
            ),
            optionB = ChoiceItem(
                textEn = "Spend a week aboard an orbital luxury space station overlooking Earth",
                textBn = "মহাকাশ স্টেশনে থেকে এক সপ্তাহ মহাবিশ্ব ও পৃথিবীর দৃশ্য উপভোগ করা",
                iconEmoji = "🛰️",
                initialVotes = 4450
            )
        ),

        // ANIMALS
        Question(
            id = "q22",
            category = QuestionCategory.ANIMALS,
            optionA = ChoiceItem(
                textEn = "Have a pet baby dragon that breathes harmless colorful sparks",
                textBn = "একটি পোষা ড্রাগনের ছানা যা ক্ষতিকর আগুন নয় বরং রঙিন স্ফুলিঙ্গ ছড়ায়",
                iconEmoji = "🐉",
                initialVotes = 4210
            ),
            optionB = ChoiceItem(
                textEn = "Have a loyal, telepathic giant wolf companion who protects you",
                textBn = "একটি অনুগত ও মনের ভাষা বোঝা বিশালাকার নেকড়ে বন্ধু যে সর্বদা রক্ষা করে",
                iconEmoji = "🐺",
                initialVotes = 3890
            )
        ),
        Question(
            id = "q23",
            category = QuestionCategory.ANIMALS,
            optionA = ChoiceItem(
                textEn = "Have the agility and night vision of a wild leopard",
                textBn = "বুনো চিতাবাঘের মতো চপল ক্ষিপ্রতা ও অন্ধকারে দেখার ক্ষমতা থাকা",
                iconEmoji = "🐆",
                initialVotes = 3450
            ),
            optionB = ChoiceItem(
                textEn = "Have the swimming endurance and lung capacity of a blue dolphin",
                textBn = "ডলফিনের মতো অবলীলায় জলের গভীরে ভেসে চলা ও সাঁতারের অসীম দম",
                iconEmoji = "🐬",
                initialVotes = 2930
            )
        ),
        Question(
            id = "q24",
            category = QuestionCategory.FUNNY,
            optionA = ChoiceItem(
                textEn = "Have arms made of noodles whenever you get angry",
                textBn = "রেগে গেলেই আপনার দুই হাত নুডলসের মতো নরম ও দোলায়মান হয়ে যাবে",
                iconEmoji = "🍜",
                initialVotes = 1780
            ),
            optionB = ChoiceItem(
                textEn = "Have hair that turns into rainbow colors depending on your mood",
                textBn = "মনের অনুভূতির ওপর নির্ভর করে মাথার চুল রঙধনুর মতো রঙ বদলাবে",
                iconEmoji = "🌈",
                initialVotes = 4050
            )
        ),
        Question(
            id = "q25",
            category = QuestionCategory.FOOD,
            optionA = ChoiceItem(
                textEn = "Eat spicy wasabi sushi rolls for breakfast every morning",
                textBn = "প্রতিদিন সকালে নাস্তায় অতিরিক্ত ঝাল ওয়াহসাবি সুশি খাওয়া",
                iconEmoji = "🍣",
                initialVotes = 1320
            ),
            optionB = ChoiceItem(
                textEn = "Eat super-sweet layered honey pancakes for dinner every night",
                textBn = "প্রতিদিন রাতের খাবারে অতিরিক্ত মিষ্টি মধুর প্যানকেক খাওয়া",
                iconEmoji = "🥞",
                initialVotes = 3690
            )
        )
    )

    private val questionsByCategory: Map<QuestionCategory, List<Question>> by lazy {
        QuestionCategory.entries.associateWith { category ->
            if (category == QuestionCategory.ALL) sampleQuestions
            else sampleQuestions.filter { it.category == category }
        }
    }

    /**
     * Returns pre-filtered question list without allocating new collections on each recomposition.
     */
    fun getQuestionsForCategory(category: QuestionCategory): List<Question> {
        return questionsByCategory[category] ?: sampleQuestions
    }
}
