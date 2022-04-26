package com.humeyramercan.animationexamples

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.humeyramercan.animationexamples.databinding.FragmentPropertyAnimationsBinding

class PropertyAnimationsFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentPropertyAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPropertyAnimationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textBackgroundColorBtn.setOnClickListener(this)
        binding.alphaAndScaleBtn.setOnClickListener(this)
        binding.rotationAndTranslationBtn.setOnClickListener(this)
        binding.mixedButton.setOnClickListener(this)
        binding.goToViewAnimationsBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.textBackgroundColorBtn.id -> {
                startAnimation(binding.textBackgroundColorTxt, R.animator.background_and_text_color)
            }
            binding.alphaAndScaleBtn.id -> {
                startAnimationWitAnimatorSet(binding.alphaAndScaleTxt, R.animator.scale_and_alpha)
            }
            binding.rotationAndTranslationBtn.id -> {
                startAnimationWitAnimatorSet(
                    binding.rotationAndTranslationTxt,
                    R.animator.rotation_and_translation
                )
            }
            binding.mixedButton.id -> {
                startAnimation(binding.mixedText, R.animator.mixed)
            }
            binding.goToViewAnimationsBtn.id->{
                val action=PropertyAnimationsFragmentDirections.actionPropertyAnimationsFragmentToViewAnimationsFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun startAnimation(view: View, anim: Int) {
        val animator = AnimatorInflater.loadAnimator(activity, anim)
        animator.apply {
            setTarget(view)
            start()
        }
    }

    private fun startAnimationWitAnimatorSet(view: View, anim: Int) {
        val animator = AnimatorInflater.loadAnimator(activity, anim) as AnimatorSet
        animator.apply {
            setTarget(view)
            start()
        }


    }
}